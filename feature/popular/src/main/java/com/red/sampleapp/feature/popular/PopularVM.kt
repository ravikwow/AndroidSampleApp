package com.red.sampleapp.feature.popular

import androidx.lifecycle.ViewModel
import com.red.sampleapp.domain.models.MovieModel
import com.red.sampleapp.domain.usecase.PopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class PopularVM @Inject constructor(
    private val popularMoviesUseCase: PopularMoviesUseCase
) : ViewModel() {
    fun getData() = flow<MovieModel> {
        emitAll(popularMoviesUseCase.execute(1).movies.asFlow())
    }
}