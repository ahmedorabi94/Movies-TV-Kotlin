package com.example.galleryapp.data.repo

import com.example.galleryapp.api.ApiService
import com.example.galleryapp.utils.BaseDataSource
import javax.inject.Inject


class MoviesFragmentRepo @Inject constructor(private val apiService: ApiService) :
    BaseDataSource() {


    private val apiKey: String = "97c261053713fdbd691f42aa664c1463"


    suspend fun getNowMoviesNew() = apiService.getNowPlayingMoviesAsync(apiKey)

    suspend fun getTopRated() = apiService.getTopRated(apiKey)

    suspend fun getPopularMovies() = apiService.getPopularMovies(apiKey)

    suspend fun getComingSoon() = apiService.getComingSoon(apiKey)

    suspend fun getTopHorrorMovies() =
        apiService.getTopHorrorMovies(apiKey, "en", "true", "true", "7", "8", "27")

    suspend fun getTopActionMovies() =
        apiService.getTopActionMovies(apiKey, "en", "true", "true", "7", "8", "28,12")

    suspend fun getTopRomanceMovies() =
        apiService.getTopRomanceMovies(apiKey, "en", "true", "true", "7.2", "8", "35,18,10749")


}