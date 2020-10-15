package com.accretion.mytaskapp.network

import com.accretion.mytaskapp.modal.now_playing.NowPlayingResponse
import com.accretion.mytaskapp.modal.search_movie.SearchMovieResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @GET("movie/now_playing")
    suspend fun nowPlaying(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): NowPlayingResponse

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): SearchMovieResponse
}