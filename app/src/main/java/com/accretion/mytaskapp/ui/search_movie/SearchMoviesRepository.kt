package com.accretion.mytaskapp.ui.search_movie

import com.accretion.mytaskapp.modal.search_movie.SearchMovieResponse
import com.accretion.mytaskapp.network.ApiResult
import com.accretion.mytaskapp.network.RetrofitClient

class SearchMoviesRepository {
    suspend fun searchMovies(page: Int, searchText: String): ApiResult<SearchMovieResponse> {
        return try {
            ApiResult.Success(
                data = RetrofitClient.instance.searchMovie(
                    "7ee9a9851df32860ef8aeacc25164222",
                    "en-US",
                    page, searchText
                )
            )
        } catch (exception: Exception) {
            ApiResult.Error(exception)
        }
    }
}