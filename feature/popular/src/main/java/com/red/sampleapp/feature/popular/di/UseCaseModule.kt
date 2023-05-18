package com.red.sampleapp.feature.popular.di

import com.red.sampleapp.domain.usecase.PopularMoviesUseCase
import com.red.sampleapp.domain.repository.MoviesPopularRepository
import com.red.sampleapp.feature.popular.repository.di.MoviesPagingModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [MoviesPagingModule::class])
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun providePopularUseCase(moviesPopularRepository: MoviesPopularRepository): PopularMoviesUseCase {
        return PopularMoviesUseCase(moviesPopularRepository)
    }
}