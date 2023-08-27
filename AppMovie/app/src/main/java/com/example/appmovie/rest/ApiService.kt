package com.example.appmovie.rest

import io.reactivex.rxjava3.core.Single
import model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/now_playing")
    fun getNowPlaying(
        @Header("Authorization") token: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Single<MovieResponse>

}