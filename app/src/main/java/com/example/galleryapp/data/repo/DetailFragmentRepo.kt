package com.example.galleryapp.data.repo

import com.example.galleryapp.api.ApiService
import com.example.galleryapp.data.entity.MovieResponse
import com.example.galleryapp.data.entity.ReviewResponse
import com.example.galleryapp.utils.AppConstants
import javax.inject.Inject

class DetailFragmentRepo @Inject constructor(private val apiService: ApiService) {


    suspend fun getReviews(id: Int, type: String): ReviewResponse {

        return if (type == "movie") {
            apiService.getReviewsMovies(id, AppConstants.apiKey)
        } else {
            apiService.getReviewsTVs(id, AppConstants.apiKey)

        }

    }
}