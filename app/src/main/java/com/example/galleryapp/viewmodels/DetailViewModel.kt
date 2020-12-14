package com.example.galleryapp.viewmodels

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.galleryapp.data.entity.MovieType
import com.example.galleryapp.data.entity.ReviewItem
import com.example.galleryapp.data.entity.ReviewResponse
import com.example.galleryapp.data.repo.DetailFragmentRepo
import com.example.galleryapp.utils.Resource

class DetailViewModel @ViewModelInject constructor(private val repo: DetailFragmentRepo) :
    ViewModel() {

    private val movieType = MutableLiveData<MovieType>()
    private val reviewItem = ObservableField<ReviewItem>()
    val reviewItemTwo = MutableLiveData<ReviewItem>()

    fun getReviews(): LiveData<Resource<ReviewResponse>> = movieType.switchMap { type ->
        liveData {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = repo.getReviews(id = type.id, type = type.type)))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }
    }


    fun setMovieType(type: MovieType) {
        movieType.value = type
    }

    fun setReview(type: ReviewItem) {
        reviewItem.set(type)
    }
    fun setReviewTwo(type: ReviewItem) {
        reviewItemTwo.value = type
    }
}