package com.example.galleryapp.ui

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {

    if (show) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE

    }
}

@BindingAdapter("posterImage")
fun LoadPoster(imageView: ImageView, url: String?) {

    url?.let {
        val baseUrl = "http://image.tmdb.org/t/p/w500"
        val finalUrl = baseUrl + url
        Glide.with(imageView.context).load(finalUrl).into(imageView)
    }


}

@BindingAdapter("voteAverage")
fun setVoteAverage(view: RatingBar, vote: Double) {

    vote.let {
        val rate = (it / 2.0).toFloat()
        view.rating = rate
    }

}