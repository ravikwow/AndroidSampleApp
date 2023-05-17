package com.red.sampleapp.repository.common.di;

import com.red.sampleapp.repository.common.AuthApi
import com.red.sampleapp.repository.common.DataStoreManager
import com.red.sampleapp.repository.common.FilmsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [FilmsModule::class])
@InstallIn(SingletonComponent::class)
class AuthModule {
    @Singleton
    @Provides
    fun provideAuthApi(filmsApi: FilmsApi, dataStore: DataStoreManager): AuthApi {
        return AuthApi(filmsApi, dataStore)
    }
}
