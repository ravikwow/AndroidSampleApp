package com.red.sampleapp.repository.dto

data class Film(
    val filmId: Long = 0,
    val nameRu: String = "",
    val nameEn: String = "",
    val year: String = "",
    val filmLength: String = "",
    val countries: List<Country> = ArrayList(),
    val genres: List<Genre> = ArrayList(),
    val rating: String = "",
    val ratingVoteCount: Long = 0,
    val posterUrl: String = "",
    val posterUrlPreview: String = "",
)
