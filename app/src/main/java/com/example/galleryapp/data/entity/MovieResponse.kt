package com.example.galleryapp.data.entity


data class MovieResponse(
    val dates: Dates,
    val page: Long,
    val results: List<Movie>,
    val total_pages: Long,
    val total_results: Long
)