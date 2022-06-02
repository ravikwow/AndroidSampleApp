package com.red.sampleapp.repository.popular

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.red.sampleapp.domain.models.MovieModel
import com.red.sampleapp.repository.common.FilmsApi
import com.red.sampleapp.repository.common.repository.MoviesPopularDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

const val NETWORK_PAGE_SIZE = 20

class MoviesRemoteDataSourceImpl @Inject constructor(
    private val filmsApi: FilmsApi
) : MoviesPopularDataSource {
    override fun getMovies(): Flow<PagingData<MovieModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviesPagingSource(filmsApi)
            }
        ).flow
    }
}
