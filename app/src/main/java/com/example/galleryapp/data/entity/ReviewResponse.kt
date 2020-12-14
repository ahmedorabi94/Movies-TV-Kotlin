package com.example.galleryapp.data.entity

data class ReviewResponse(
    val id: Long,
    val page: Long,
    val results: List<ReviewItem>,
    val total_pages: Long,
    val total_results: Long
)