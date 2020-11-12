package com.example.galleryapp.ui.callback

import com.example.galleryapp.data.entity.Movie

interface MovieCallback {

    fun onClickMovie(movie: Movie)
}