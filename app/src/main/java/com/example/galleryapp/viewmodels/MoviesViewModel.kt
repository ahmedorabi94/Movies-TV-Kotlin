package com.example.galleryapp.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.galleryapp.data.repo.MoviesFragmentRepo
import com.example.galleryapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import timber.log.Timber

class MoviesViewModel @ViewModelInject constructor(private val repo: MoviesFragmentRepo) :
    ViewModel() {


    private var viewModelJob = Job()
    //  private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    fun getMovies() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getNowMoviesNew()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }

    fun getTopRatedMovies() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getTopRated()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getPopularMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getPopularMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


    fun getComingSoonMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))

        try {
            emit(Resource.success(data = repo.getComingSoon()))

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getTopHorrorMovies() = liveData(Dispatchers.IO) {


        emit(Resource.loading(data = null))

        try {
            emit(Resource.success(data = repo.getTopHorrorMovies()))

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getTopActionMovies() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))

        try {
            emit(Resource.success(data = repo.getTopActionMovies()))

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getTopRomanceMovies() = liveData(Dispatchers.IO) {

        Timber.e("MoviesFragmentRepo")

        emit(Resource.loading(data = null))
        Timber.e("Resource.loading()")

        try {
            emit(Resource.success(data = repo.getTopRomanceMovies()))
            Timber.e("Resource.success()")

        } catch (exception: Exception) {
            Timber.e(exception)
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}