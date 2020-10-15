package com.accretion.mytaskapp.ui.movies

import com.accretion.mytaskapp.modal.now_playing.NowPlayingResponse
import com.accretion.mytaskapp.modal.search_movie.SearchMovieResponse
import com.accretion.mytaskapp.network.ApiResult
import com.accretion.mytaskapp.network.RetrofitClient

class MoviesRepository {
    suspend fun nowPlaying(page: Int): ApiResult<NowPlayingResponse> {
        return try {
            ApiResult.Success(
                data = RetrofitClient.instance.nowPlaying(
                    "7ee9a9851df32860ef8aeacc25164222",
                    "en-US",
                    page
                )
            )
        } catch (exception: Exception) {
            ApiResult.Error(exception)
        }
    }
}