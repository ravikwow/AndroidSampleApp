package com.red.sampleapp.domain.models

import kotlinx.coroutines.flow.Flow

class MovieResponseFlow(val movies: Flow<MovieModel>, val maxPagesCount: Int) {
}