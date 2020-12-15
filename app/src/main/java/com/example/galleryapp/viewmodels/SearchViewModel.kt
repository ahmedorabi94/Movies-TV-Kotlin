package com.example.galleryapp.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.galleryapp.data.entity.MovieResponse
import com.example.galleryapp.data.repo.SearchRepository
import com.example.galleryapp.utils.Resource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel @ViewModelInject constructor(private val repository: SearchRepository) :
    ViewModel() {

    private val _movies = MutableLiveData<MovieResponse>()
    val movies: LiveData<MovieResponse> get() = _movies


//    private val _movies = MutableStateFlow<Resource<MovieResponse>>(Resource.loading(null))
//
//    val movies: StateFlow<Resource<MovieResponse>> get() = _movies

    // val query = MutableLiveData<String>()

    private val queryStr: String = ""


    fun getMovies(query: String): Flow<MovieResponse> {
        return flow {

            repository.getSearchMovies(query)
                .onStart {
                    // loading
                    Timber.e("Start")

                }
                .catch { exception ->
                    // error
                    Timber.e(exception)
                }
                .onCompletion {
                    Timber.e("onCompletion")
                }
                .collect { response ->
                    _movies.value = response
                    // emit(response)
                }


        }

    }


    fun getMoviesTwo(q: String) {
        viewModelScope.launch {
            repository.getSearchMovies(q)
                .onStart {
                    // loading
                    Timber.e("Start")

                }
                .catch { exception ->
                    // error
                    Timber.e(exception)
                }
                .onCompletion {
                    Timber.e("onCompletion")
                }
                .collect { response ->
                    _movies.value = response
                }

        }
    }


    // LiveData builder
    val movieResult: LiveData<MovieResponse> = liveData {
        repository.getSearchMovies(queryStr)
            .collect {
                emit(it)
            }
    }

    // in one line
    val movieResult2: LiveData<MovieResponse> = repository.getSearchMovies("").asLiveData()


    val movieResult3: LiveData<MovieResponse> = liveData {
        repository.getSearchMovies("")
            .onStart {
                // emit("Loading_STRING")
            }
            .asLiveData()


    }

    val movieResult4: LiveData<Resource<MovieResponse>> = liveData {
        repository.getSearchMovies("")
            .onStart {
                emit(Resource.loading(data = null))
            }
            .asLiveData()
        //            .collect {
//                emit(Resource.success(data = it))
//            }


    }


}