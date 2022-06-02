package com.red.sampleapp.domain.usecase

import androidx.paging.PagingData
import com.red.sampleapp.domain.models.MovieModel
import com.red.sampleapp.repository.common.repository.MoviesPopularDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(private val moviesPopularDataSource: MoviesPopularDataSource) {
    suspend fun execute(): Flow<PagingData<MovieModel>> {
        return moviesPopularDataSource.getMovies()
    }
}