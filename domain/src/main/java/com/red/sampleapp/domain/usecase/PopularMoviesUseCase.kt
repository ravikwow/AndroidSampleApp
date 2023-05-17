package com.red.sampleapp.domain.usecase

import androidx.paging.PagingData
import com.red.sampleapp.domain.models.MovieModel
import com.red.sampleapp.domain.repository.MoviesPopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(private val moviesPopularRepository: MoviesPopularRepository) {
    fun execute(): Flow<PagingData<MovieModel>> {
        return moviesPopularRepository.getMovies()
    }
}