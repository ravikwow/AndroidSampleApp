package com.red.sampleapp.auth.repository

import com.red.sampleapp.auth.domain.AuthRepository
import com.red.sampleapp.repository.common.AuthApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun auth(apiKey: String): Any = withContext(Dispatchers.IO) {
        authApi.auth(apiKey)
    }
}