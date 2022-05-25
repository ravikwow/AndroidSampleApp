package com.red.sampleapp.domain.models

data class MovieModel(
    val id: Long,
    val name: String = "",
    val year: String = "",
    val filmLength: String = "",
    val countries: List<String> = ArrayList(),
    val genres: List<String> = ArrayList(),
    val rating: String = "",
    val ratingVoteCount: Long = 0,
    val posterUrl: String = "",
    val posterUrlPreview: String = "",
)
