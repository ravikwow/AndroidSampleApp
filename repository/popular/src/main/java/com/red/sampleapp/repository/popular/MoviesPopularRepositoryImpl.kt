package com.red.sampleapp.repository.popular

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.red.sampleapp.domain.models.MovieModel
import com.red.sampleapp.repository.common.FilmsApi
import com.red.sampleapp.domain.repository.MoviesPopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesPopularRepositoryImpl @Inject constructor(
    private val filmsApi: FilmsApi
) : MoviesPopularRepository {
    override fun getMovies(): Flow<PagingData<MovieModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = MoviesPagingSource.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviesPagingSource(filmsApi)
            }
        ).flow
    }
}
