package com.example.galleryapp.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.galleryapp.api.ApiService
import com.example.galleryapp.data.entity.MovieResponse
import com.example.galleryapp.data.repo.MoviesFragmentRepo
import com.example.galleryapp.paging.MoviePagingSource
import com.example.galleryapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MoviesViewModel @ViewModelInject constructor(
    private val repo: MoviesFragmentRepo,
    private val apiService: ApiService
) :
    ViewModel() {

    private val _movieResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieTopRatedResponse: LiveData<Resource<MovieResponse>> get() = _movieResponse

    private val _moviePopularResponse = MutableLiveData<Resource<MovieResponse>>()
    val moviePopularResponse: LiveData<Resource<MovieResponse>> get() = _moviePopularResponse

    private val _movieSoonResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieSoonResponse: LiveData<Resource<MovieResponse>> get() = _movieSoonResponse

    private val _movieHorrorResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieHorrorResponse: LiveData<Resource<MovieResponse>> get() = _movieHorrorResponse

    private val _movieActionResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieActionResponse: LiveData<Resource<MovieResponse>> get() = _movieActionResponse

    private val _movieRomanceResponse = MutableLiveData<Resource<MovieResponse>>()
    val movieRomanceResponse: LiveData<Resource<MovieResponse>> get() = _movieRomanceResponse


    init {
        getTopRatedMovies()
        getPopularMovies()
        getComingSoonMovies()
        getTopHorrorMovies()
        getTopActionMovies()
        getTopRomanceMovies()
    }

    val listData = Pager(PagingConfig(pageSize = 20)) {
        MoviePagingSource(apiService)
    }.flow.cachedIn(viewModelScope)

    fun getMovies() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getNowMoviesNew()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

    private fun getTopRatedMovies() {

        viewModelScope.launch {
            _movieResponse.value = Resource.loading(data = null)

            try {
                _movieResponse.value = Resource.success(data = repo.getTopRated())
            } catch (exception: Exception) {
                _movieResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }

    }

    private fun getPopularMovies()  {

        viewModelScope.launch {
            _moviePopularResponse.value = Resource.loading(data = null)

            try {
                _moviePopularResponse.value = Resource.success(data = repo.getPopularMovies())
            } catch (exception: Exception) {
                _moviePopularResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }
    }
    private fun getComingSoonMovies()  {

        viewModelScope.launch {
            _movieSoonResponse.value = Resource.loading(data = null)

            try {
                _movieSoonResponse.value = Resource.success(data = repo.getComingSoon())
            } catch (exception: Exception) {
                _movieSoonResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }
    }
    private fun getTopHorrorMovies() {

        viewModelScope.launch {
            _movieHorrorResponse.value = Resource.loading(data = null)

            try {
                _movieHorrorResponse.value = Resource.success(data = repo.getTopHorrorMovies())
            } catch (exception: Exception) {
                _movieHorrorResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }
    }



    private fun getTopActionMovies()  {

        viewModelScope.launch {
            _movieActionResponse.value = Resource.loading(data = null)

            try {
                _movieActionResponse.value = Resource.success(data = repo.getTopActionMovies())
            } catch (exception: Exception) {
                _movieActionResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }
    }

    private fun getTopRomanceMovies()  {

        viewModelScope.launch {
            _movieRomanceResponse.value = Resource.loading(data = null)

            try {
                _movieRomanceResponse.value = Resource.success(data = repo.getTopRomanceMovies())
            } catch (exception: Exception) {
                _movieRomanceResponse.value =
                    Resource.error(data = null, message = exception.message ?: "Error Occurred!")

            }
        }
    }


}