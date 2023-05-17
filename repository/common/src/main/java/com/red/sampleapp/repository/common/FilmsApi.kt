package com.red.sampleapp.repository.common

import com.red.sampleapp.repository.common.dto.FilmAuth
import com.red.sampleapp.repository.common.dto.FilmsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface FilmsApi {
    @GET("v2.2/films/top")
    @Headers("accept: application/json")
    suspend fun getPopular(
        @Query("page") page: Int = 1,
        @Query("type") type: String = "TOP_100_POPULAR_FILMS"
    ): FilmsResponse

    @GET("v2.2/films/666")
    @Headers("accept: application/json")
    suspend fun auth(@Header("X-API-Key") contentRange: String = ""): FilmAuth
}
