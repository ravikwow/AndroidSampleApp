package com.red.sampleapp.repository.common

import com.red.sampleapp.repository.common.dto.FilmAuth

class AuthApi(private val filmsApi: FilmsApi, private val dataStore: DataStoreManager) {
    suspend fun auth(apiKey: String): FilmAuth {
        val filmAuth = filmsApi.auth(apiKey)
        dataStore.putApiKey(apiKey)
        return filmAuth
    }
}