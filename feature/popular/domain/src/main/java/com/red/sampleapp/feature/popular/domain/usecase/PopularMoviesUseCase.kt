package com.red.sampleapp.feature.popular.domain.usecase

import androidx.paging.PagingData
import com.red.sampleapp.feature.popular.domain.models.MovieModel
import com.red.sampleapp.feature.popular.domain.repository.MoviesPopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(private val moviesPopularRepository: MoviesPopularRepository) {
    fun execute(): Flow<PagingData<MovieModel>> {
        return moviesPopularRepository.getMovies()
    }
}