package com.red.sampleapp.domain.repository

import androidx.paging.PagingData
import com.red.sampleapp.domain.models.MovieModel
import kotlinx.coroutines.flow.Flow

interface MoviesPopularRepository {
    fun getMovies(): Flow<PagingData<MovieModel>>
}