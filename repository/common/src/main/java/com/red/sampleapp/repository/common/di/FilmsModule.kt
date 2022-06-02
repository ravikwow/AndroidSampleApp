package com.red.sampleapp.repository.common.di

import com.red.sampleapp.repository.common.FilmsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class FilmsModule {
    @Singleton
    @Provides
    fun provideFilmsApi(retrofit: Retrofit): FilmsApi {
        return retrofit.create(FilmsApi::class.java)
    }
}