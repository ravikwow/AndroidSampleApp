package com.red.sampleapp.auth.domain

import javax.inject.Inject

class AuthUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun execute(apiKey: String): Any {
        return authRepository.auth(apiKey)
    }
}