package com.red.sampleapp.repository.common.repository

import androidx.paging.PagingData
import com.red.sampleapp.domain.models.MovieModel
import kotlinx.coroutines.flow.Flow

interface MoviesPopularRepository {
    fun getMovies(): Flow<PagingData<MovieModel>>
}