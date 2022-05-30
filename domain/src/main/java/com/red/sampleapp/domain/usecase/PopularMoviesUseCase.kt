package com.red.sampleapp.domain.usecase

import com.red.sampleapp.domain.models.MovieResponse
import com.red.sampleapp.domain.repository.MovieRepository
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend fun execute(page: Int): MovieResponse {
        return movieRepository.getPopularMovies(page)
    }
}