package com.accretion.mytaskapp.modal.search_movie

data class SearchMovieResponse(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)