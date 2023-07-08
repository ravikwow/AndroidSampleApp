package com.red.sampleapp.domain

import com.red.sampleapp.repository.common.DataStoreManager
import javax.inject.Inject

class ApiKeyUseCase @Inject constructor(private val dataStoreManager: DataStoreManager) {

    suspend fun checkApiKey(): Boolean {
        return dataStoreManager.checkApiKey()
    }

    suspend fun removeApiKey() {
        dataStoreManager.removeApiKey()
    }
}