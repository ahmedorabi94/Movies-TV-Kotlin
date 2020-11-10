package com.example.galleryapp.data.entity

import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum")
    val mMaximum: String,
    @SerializedName("minimum")
    val mMinimum: String
)