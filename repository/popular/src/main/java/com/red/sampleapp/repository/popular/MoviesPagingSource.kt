package com.red.sampleapp.repository.popular

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.red.sampleapp.domain.models.MovieModel
import com.red.sampleapp.repository.common.FilmsApi
import com.red.sampleapp.repository.common.dto.Film
import com.red.sampleapp.repository.common.dto.FilmsResponse
import java.util.*

class MoviesPagingSource(
    private val filmsApi: FilmsApi
) : PagingSource<Int, MovieModel>() {

    companion object {
        private const val STARTING_PAGE_INDEX = 1
        const val NETWORK_PAGE_SIZE = 20
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX
        return try {
            val pageCount = params.loadSize / NETWORK_PAGE_SIZE
            val response = if (pageCount > 1) {
                var maxCount = 0
                val movies = LinkedList<Film>()
                for (i in pageIndex until pageIndex + pageCount) {
                    Log.d("MoviesPagingSource", "page $i")
                    val response = filmsApi.getPopular(i)
                    maxCount = response.pagesCount
                    movies.addAll(response.films)
                }
                FilmsResponse(maxCount, movies)
            } else {
                Log.d("MoviesPagingSource", "page $pageIndex")
                filmsApi.getPopular(pageIndex)
            }
            val movies = response.films.map { it.toMovie() }
            Log.d("MoviesPagingSource", "page count " + movies.size)
            val nextKey =
                if ((pageIndex + pageCount - 1) >= response.pagesCount || movies.isEmpty()) {
                    Log.d("MoviesPagingSource", "last page")
                    null
                } else {
                    pageIndex + pageCount
                }
            LoadResult.Page(
                data = movies,
                prevKey = if (pageIndex == STARTING_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (throwable: Throwable) {
            return LoadResult.Error(throwable)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

fun Film.toMovie(): MovieModel {
    return MovieModel(
        filmId ?: -1,
        nameRu ?: nameEn ?: "",
        year ?: "",
        filmLength ?: "",
        countries?.map { it.country } ?: Collections.emptyList(),
        genres?.map { it.genre } ?: Collections.emptyList(),
        rating ?: "",
        ratingVoteCount ?: -1,
        posterUrl ?: "",
        posterUrlPreview ?: ""
    )
}