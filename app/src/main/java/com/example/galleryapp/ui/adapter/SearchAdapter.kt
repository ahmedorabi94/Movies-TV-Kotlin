package com.example.galleryapp.ui.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryapp.data.entity.Movie
import com.example.galleryapp.databinding.SearchRowItemBinding

class SearchAdapter() :
    ListAdapter<Movie, SearchAdapter.MyViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            SearchRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)


    }


    class MyViewHolder(private val binding: SearchRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movieItem = movie

            if (movie.media_type == "movie") {
                binding.titleRow.text = movie.title
            } else if (movie.media_type == "tv") {
                binding.titleRow.text = movie.name
            }

            val overview = movie.overview

            if (!TextUtils.isEmpty(overview)) {
                binding.overviewRow.text = overview

            } else {
                binding.overviewRow.text = "N/A"
            }

            val url = movie.poster_path

            if (!TextUtils.isEmpty(url)) {
                val baseUrl = "http://image.tmdb.org/t/p/w200"
                val finalUrl = baseUrl + url
                Glide.with(binding.root.context)
                    .load(finalUrl)
                    .into(binding.imageRowItem)
            }

        }

    }
}
