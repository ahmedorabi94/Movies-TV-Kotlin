package com.example.galleryapp.utils

import retrofit2.Response
import timber.log.Timber

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {

        Timber.e("getResult")


        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                Timber.e(body.toString())
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            Timber.e("getResult ${e.message}")

            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Timber.e(message)
        return Resource.error("Network call has failed for a following reason: $message")
    }

}