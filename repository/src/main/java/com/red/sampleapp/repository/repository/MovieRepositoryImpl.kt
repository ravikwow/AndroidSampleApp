package com.red.sampleapp.repository.repository

import com.red.sampleapp.domain.models.MovieModel
import com.red.sampleapp.domain.models.MovieResponse
import com.red.sampleapp.domain.repository.MovieRepository
import com.red.sampleapp.repository.FilmsApi
import com.red.sampleapp.repository.dto.Film
import com.red.sampleapp.repository.dto.FilmsResponse
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val filmsApi: FilmsApi) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return filmsApi.getPopular(page).toMovieResponse()
    }
}

fun FilmsResponse.toMovieResponse(): MovieResponse {
    return MovieResponse(films.map { it.toMovie() }, pagesCount)
}

fun Film.toMovie(): MovieModel {
    return MovieModel(
        filmId,
        nameRu,
        year,
        filmLength,
        countries.map { it.country },
        genres.map { it.genre },
        rating, ratingVoteCount, posterUrl, posterUrlPreview
    )
}