package com.red.sampleapp.domain.repository

import com.red.sampleapp.domain.models.MovieResponse

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MovieResponse
}