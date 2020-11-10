package com.example.galleryapp.data.repo

import com.example.galleryapp.api.ApiService
import javax.inject.Inject

class TVRepository @Inject constructor(private val apiService: ApiService) {

    private val apiKey: String = "97c261053713fdbd691f42aa664c1463"


    suspend fun getTopRatedTVSHOWS() = apiService.getTopRatedTVSHOWS(apiKey)
    suspend fun getPopularTVSHOWS() = apiService.getPopularTVSHOWS(apiKey)
    suspend fun getAiringTodayTVSHOWS() = apiService.getAiringTodayTVSHOWS(apiKey)
    suspend fun getOnTheAirTVSHOWS() = apiService.getOnTheAirTVSHOWS(apiKey)

    suspend fun getTopActionTv() = apiService.DiscoverTopTV(apiKey, "7.2", "10759")
    suspend fun getTopCrimeTv() = apiService.DiscoverTopTV(apiKey, "8", "18,80")
    suspend fun getTopComedyTv() = apiService.DiscoverTopTV(apiKey, "7.8", "35")
    suspend fun getTopWarTv() = apiService.DiscoverTopTV(apiKey, "7.8", "10768")


}