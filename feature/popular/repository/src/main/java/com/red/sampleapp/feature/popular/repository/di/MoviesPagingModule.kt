package com.red.sampleapp.feature.popular.repository.di

import com.red.sampleapp.repository.common.di.FilmsModule
import com.red.sampleapp.feature.popular.domain.repository.MoviesPopularRepository
import com.red.sampleapp.feature.popular.repository.MoviesPopularRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [FilmsModule::class])
@InstallIn(SingletonComponent::class)
abstract class MoviesPagingModule {
    @Binds
    abstract fun bindMoviesPopularDataSource(MoviesPopularRepositoryImpl: MoviesPopularRepositoryImpl): MoviesPopularRepository
}