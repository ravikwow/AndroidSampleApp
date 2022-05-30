package com.red.sampleapp.domain.repository

import com.red.sampleapp.domain.models.MovieResponse
import com.red.sampleapp.domain.models.MovieResponseFlow

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MovieResponse
}