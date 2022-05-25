package com.red.sampleapp.repository

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val request = original.newBuilder()
            .header("X-API-Key", BuildConfig.X_API_KEY)
            .method(original.method, original.body)
            .build()

        return chain.proceed(request)
    }
}