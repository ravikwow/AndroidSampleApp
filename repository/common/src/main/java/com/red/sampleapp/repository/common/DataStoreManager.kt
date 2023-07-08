package com.red.sampleapp.repository.common

import android.content.Context
import android.text.TextUtils
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreManager @Inject constructor(@ApplicationContext appContext: Context) {
    private val Context.dataStore by preferencesDataStore("repository_common_data_store")
    private val dataStore = appContext.dataStore

    private suspend fun <T> DataStore<Preferences>.getFromLocalStorage(
        preferencesKey: Preferences.Key<T>
    ): Flow<T?> {
        return data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[preferencesKey]
        }
    }

    private suspend fun <T> DataStore<Preferences>.getFromLocalStorage(
        preferencesKey: Preferences.Key<T>, func: T.() -> T
    ) {
        getFromLocalStorage(preferencesKey).collect {
            it?.let { func.invoke(it as T) }
        }
    }

    @Suppress("MemberVisibilityCanBePrivate", "unused")
    suspend fun <T> storeValue(key: Preferences.Key<T>, value: T) {
        dataStore.edit {
            it[key] = value
        }
    }

    @Suppress("MemberVisibilityCanBePrivate", "unused")
    suspend fun <T> removeValue(key: Preferences.Key<T>) {
        dataStore.edit {
            it.remove(key)
        }
    }

    @Suppress("MemberVisibilityCanBePrivate", "unused")
    suspend fun <T> readValue(key: Preferences.Key<T>, responseFunc: T.() -> T) {
        dataStore.getFromLocalStorage(key) {
            responseFunc.invoke(this)
        }
    }

    suspend fun putApiKey(apiKey: String) {
        storeValue(stringPreferencesKey("apiKey"), apiKey)
    }

    suspend fun getApiKey(): String {
        return dataStore.getFromLocalStorage(stringPreferencesKey("apiKey")).first() ?: ""
    }

    suspend fun checkApiKey(): Boolean {
        return !TextUtils.isEmpty(getApiKey())
    }

    suspend fun removeApiKey() {
        removeValue(stringPreferencesKey("apiKey"))
    }
}
