package com.red.sampleapp.feature.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.red.sampleapp.domain.usecase.PopularMoviesUseCase
import com.red.sampleapp.feature.popular.models.MovieUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PopularVM @Inject constructor(
    private val popularMoviesUseCase: PopularMoviesUseCase,
) : ViewModel() {

    fun getMovies(): Flow<PagingData<MovieUI>> {
        return popularMoviesUseCase.execute()
            .map { pagingDataMovieModel ->
                pagingDataMovieModel.map { movieModel ->
                    MovieUI(movieModel.id, movieModel.name)
                }
            }
            .cachedIn(viewModelScope)
    }
}

