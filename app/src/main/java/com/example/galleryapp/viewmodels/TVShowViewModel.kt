package com.example.galleryapp.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.entity.MovieResponse
import com.example.galleryapp.data.repo.TVRepository
import com.example.galleryapp.utils.Resource
import kotlinx.coroutines.launch

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

    private fun getTopRatedTVSHOWS() {

        viewModelScope.launch {
            _movieResponse.value = Resource.loading(data = null)

            try {
                _movieResponse.value = Resource.success(data = repo.getTopRatedTVSHOWS())
            } catch (exception: Exception) {
                _movieResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }

    }

    private fun getPopularTVSHOWS() {

        viewModelScope.launch {
            _moviePopularResponse.value = Resource.loading(data = null)

            try {
                _moviePopularResponse.value = Resource.success(data = repo.getPopularTVSHOWS())
            } catch (exception: Exception) {
                _moviePopularResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }
    }

    private fun getAiringTodayTVSHOWS() {

        viewModelScope.launch {
            _movieAiringTodayResponse.value = Resource.loading(data = null)

            try {
                _movieAiringTodayResponse.value =
                    Resource.success(data = repo.getAiringTodayTVSHOWS())
            } catch (exception: Exception) {
                _movieAiringTodayResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }

    }

    private fun getOnTheAirTVSHOWS() {

        viewModelScope.launch {
            _movieOnTheAirResponse.value = Resource.loading(data = null)

            try {
                _movieOnTheAirResponse.value = Resource.success(data = repo.getOnTheAirTVSHOWS())
            } catch (exception: Exception) {
                _movieOnTheAirResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }

    }

    private fun getTopActionTv() {

        viewModelScope.launch {
            _movieActionResponse.value = Resource.loading(data = null)

            try {
                _movieActionResponse.value = Resource.success(data = repo.getTopActionTv())
            } catch (exception: Exception) {
                _movieActionResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }
    }


    private fun getTopCrimeTv() {

        viewModelScope.launch {
            _movieTopCrimeResponse.value = Resource.loading(data = null)

            try {
                _movieTopCrimeResponse.value = Resource.success(data = repo.getTopCrimeTv())
            } catch (exception: Exception) {
                _movieTopCrimeResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }
    }

    private fun getTopComedyTv() {

        viewModelScope.launch {
            _movieTopComedyResponse.value = Resource.loading(data = null)

            try {
                _movieTopComedyResponse.value = Resource.success(data = repo.getTopComedyTv())
            } catch (exception: Exception) {
                _movieTopComedyResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }

    }

    private fun getTopWarTv() {

        viewModelScope.launch {
            _movieTopWarResponse.value = Resource.loading(data = null)

            try {
                _movieTopWarResponse.value = Resource.success(data = repo.getTopWarTv())
            } catch (exception: Exception) {
                _movieTopWarResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }

    }

}