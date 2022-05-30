package com.red.sampleapp.feature.popular

import com.red.sampleapp.domain.repository.MovieRepository
import com.red.sampleapp.domain.usecase.PopularMoviesUseCase
import com.red.sampleapp.repository.FilmsApi
import com.red.sampleapp.repository.FilmsModule
import com.red.sampleapp.repository.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [FilmsModule::class])
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providePopularUseCase(movieRepository: MovieRepository): PopularMoviesUseCase {
        return PopularMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(filmsApi: FilmsApi): MovieRepository {
        return MovieRepositoryImpl(filmsApi)
    }
}