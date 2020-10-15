package com.accretion.mytaskapp.modal.now_playing

import com.accretion.mytaskapp.modal.search_movie.MovieResult

data class NowPlayingResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)