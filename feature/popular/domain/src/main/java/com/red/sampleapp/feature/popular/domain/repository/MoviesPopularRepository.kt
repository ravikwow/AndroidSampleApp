package com.red.sampleapp.feature.popular.domain.repository

import androidx.paging.PagingData
import com.red.sampleapp.feature.popular.domain.models.MovieModel
import kotlinx.coroutines.flow.Flow

interface MoviesPopularRepository {
    fun getMovies(): Flow<PagingData<MovieModel>>
}