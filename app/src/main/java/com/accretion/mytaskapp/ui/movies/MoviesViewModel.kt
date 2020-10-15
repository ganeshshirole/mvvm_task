package com.accretion.mytaskapp.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accretion.mytaskapp.modal.now_playing.NowPlayingResponse
import com.accretion.mytaskapp.network.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel: ViewModel() {

    private val moviesRepository: MoviesRepository = MoviesRepository()
    val moviesLiveData: MutableLiveData<ApiResult<NowPlayingResponse>> = MutableLiveData()

    fun nowPlaying(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val moviesResponse = moviesRepository.nowPlaying(page)
            withContext(Dispatchers.Main) {
                moviesLiveData.value = moviesResponse
            }
        }
    }
}