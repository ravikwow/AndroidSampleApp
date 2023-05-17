package com.red.sampleapp.auth.domain

interface AuthRepository {
    suspend fun auth(apiKey: String): Any
}