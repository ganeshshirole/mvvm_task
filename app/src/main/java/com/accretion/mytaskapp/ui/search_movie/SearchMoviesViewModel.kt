package com.accretion.mytaskapp.ui.search_movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accretion.mytaskapp.modal.now_playing.NowPlayingResponse
import com.accretion.mytaskapp.modal.search_movie.SearchMovieResponse
import com.accretion.mytaskapp.network.ApiResult
import com.accretion.mytaskapp.ui.movies.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchMoviesViewModel: ViewModel() {
    private val moviesRepository: SearchMoviesRepository = SearchMoviesRepository()
    val moviesLiveData: MutableLiveData<ApiResult<SearchMovieResponse>> = MutableLiveData()

    fun searchMovies(page: Int, text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val moviesResponse = moviesRepository.searchMovies(page, text)
            withContext(Dispatchers.Main) {
                moviesLiveData.value = moviesResponse
            }
        }
    }
}