package com.example.galleryapp.data.repo

import com.example.galleryapp.api.ApiService
import com.example.galleryapp.utils.AppConstants
import javax.inject.Inject

class TVRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getTopRatedTVSHOWS() = apiService.getTopRatedTVSHOWS(AppConstants.apiKey)
    suspend fun getPopularTVSHOWS() = apiService.getPopularTVSHOWS(AppConstants.apiKey)
    suspend fun getAiringTodayTVSHOWS() = apiService.getAiringTodayTVSHOWS(AppConstants.apiKey)
    suspend fun getOnTheAirTVSHOWS() = apiService.getOnTheAirTVSHOWS(AppConstants.apiKey)

    suspend fun getTopActionTv() = apiService.DiscoverTopTV(AppConstants.apiKey, "7.2", "10759")
    suspend fun getTopCrimeTv() = apiService.DiscoverTopTV(AppConstants.apiKey, "8", "18,80")
    suspend fun getTopComedyTv() = apiService.DiscoverTopTV(AppConstants.apiKey, "7.8", "35")
    suspend fun getTopWarTv() = apiService.DiscoverTopTV(AppConstants.apiKey, "7.8", "10768")


}