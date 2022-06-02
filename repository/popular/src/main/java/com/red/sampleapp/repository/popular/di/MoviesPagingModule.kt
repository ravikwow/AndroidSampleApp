package com.red.sampleapp.repository.popular.di

import com.red.sampleapp.repository.common.FilmsApi
import com.red.sampleapp.repository.common.di.FilmsModule
import com.red.sampleapp.repository.common.repository.MoviesPopularDataSource
import com.red.sampleapp.repository.popular.MoviesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [FilmsModule::class])
@InstallIn(SingletonComponent::class)
class MoviesPagingModule {
    @Singleton
    @Provides
    fun provideMoviesRemoteDataSource(filmsApi: FilmsApi): MoviesPopularDataSource {
        return MoviesRemoteDataSourceImpl(filmsApi)
    }
}