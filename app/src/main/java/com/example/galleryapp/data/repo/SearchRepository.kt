package com.example.galleryapp.data.repo

import com.example.galleryapp.api.ApiService
import com.example.galleryapp.data.entity.MovieResponse
import com.example.galleryapp.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SearchRepository @Inject constructor(private val apiService: ApiService) {


    fun getSearchMovies(query : String) : Flow<MovieResponse>{

        return flow {
            val movies = apiService.searchMoviesApi(AppConstants.apiKey,query)

            emit(movies)
        }.flowOn(Dispatchers.IO)

    }


}