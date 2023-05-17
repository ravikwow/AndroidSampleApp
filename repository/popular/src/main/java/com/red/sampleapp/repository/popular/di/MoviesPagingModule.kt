package com.red.sampleapp.repository.popular.di

import com.red.sampleapp.repository.common.di.FilmsModule
import com.red.sampleapp.domain.repository.MoviesPopularRepository
import com.red.sampleapp.repository.popular.MoviesPopularRepositoryImpl
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