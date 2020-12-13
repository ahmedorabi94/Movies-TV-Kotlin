package com.example.galleryapp.data.repo

import com.example.galleryapp.api.ApiService
import com.example.galleryapp.utils.AppConstants
import com.example.galleryapp.utils.BaseDataSource
import javax.inject.Inject


class MoviesFragmentRepo @Inject constructor(private val apiService: ApiService) :
    BaseDataSource() {




    suspend fun getNowMoviesNew() = apiService.getNowPlayingMoviesAsync(AppConstants.apiKey)

    suspend fun getTopRated() = apiService.getTopRated(AppConstants.apiKey)

    suspend fun getPopularMovies() = apiService.getPopularMovies(AppConstants.apiKey)

    suspend fun getComingSoon() = apiService.getComingSoon(AppConstants.apiKey)

    suspend fun getTopHorrorMovies() =
        apiService.getTopHorrorMovies(AppConstants.apiKey, "en", "true", "true", "7", "8", "27")

    suspend fun getTopActionMovies() =
        apiService.getTopActionMovies(AppConstants.apiKey, "en", "true", "true", "7", "8", "28,12")

    suspend fun getTopRomanceMovies() =
        apiService.getTopRomanceMovies(AppConstants.apiKey, "en", "true", "true", "7.2", "8", "35,18,10749")


}