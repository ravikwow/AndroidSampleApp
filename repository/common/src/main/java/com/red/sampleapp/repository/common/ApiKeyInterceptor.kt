package com.red.sampleapp.repository.common

import android.text.TextUtils
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor(private val dataStoreManager: DataStoreManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        return if (TextUtils.isEmpty(original.header("X-API-Key"))) {
            val apiKey = dataStoreManager.getApiKey()
            if (TextUtils.isEmpty(apiKey)) {
                throw java.lang.Exception("Please login")
            } else {
                val request = original.newBuilder()
                    .headers(original.headers)
                    .header("X-API-Key", apiKey)
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request)
            }
        } else {
            chain.proceed(original)
        }
    }
}