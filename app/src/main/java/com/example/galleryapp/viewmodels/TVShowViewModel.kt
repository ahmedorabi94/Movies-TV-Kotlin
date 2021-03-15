package com.example.galleryapp.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.galleryapp.data.entity.MovieResponse
import com.example.galleryapp.data.repo.TVRepository
import com.example.galleryapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class TVShowViewModel @ViewModelInject constructor(private val repo: TVRepository) : ViewModel() {

    private val _movieResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieTopRatedResponse: LiveData<Resource<MovieResponse>> get() = _movieResponse

    private val _moviePopularResponse = MutableLiveData<Resource<MovieResponse>>()
    val moviePopularResponse: LiveData<Resource<MovieResponse>> get() = _moviePopularResponse

    private val _movieAiringTodayResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieAiringTodayResponse: LiveData<Resource<MovieResponse>> get() = _movieAiringTodayResponse

    private val _movieOnTheAirResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieOnTheAirResponse: LiveData<Resource<MovieResponse>> get() = _movieOnTheAirResponse

    private val _movieActionResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieActionResponse: LiveData<Resource<MovieResponse>> get() = _movieActionResponse

    private val _movieTopCrimeResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieTopCrimeResponse: LiveData<Resource<MovieResponse>> get() = _movieTopCrimeResponse

    private val _movieTopComedyResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieTopComedyResponse: LiveData<Resource<MovieResponse>> get() = _movieTopComedyResponse

    private val _movieTopWarResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieTopWarResponse: LiveData<Resource<MovieResponse>> get() = _movieTopWarResponse

    init {
        getTopWarTv()
        getTopComedyTv()
        getTopCrimeTv()
        getTopActionTv()
        getOnTheAirTVSHOWS()
        getAiringTodayTVSHOWS()
        getPopularTVSHOWS()
        getTopRatedTVSHOWS()
    }

    fun getTopRatedTVSHOWS() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getTopRatedTVSHOWS()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

    fun getPopularTVSHOWS() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getPopularTVSHOWS()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

    fun getAiringTodayTVSHOWS() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getAiringTodayTVSHOWS()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

    fun getOnTheAirTVSHOWS() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getOnTheAirTVSHOWS()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

    fun getTopActionTv() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getTopActionTv()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }


    fun getTopCrimeTv() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getTopCrimeTv()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

    fun getTopComedyTv() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getTopComedyTv()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

    fun getTopWarTv() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getTopWarTv()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

}