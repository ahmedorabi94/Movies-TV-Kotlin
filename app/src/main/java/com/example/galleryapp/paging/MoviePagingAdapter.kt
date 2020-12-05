package com.example.galleryapp.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryapp.data.entity.Movie
import com.example.galleryapp.databinding.GridViewItemBinding
import com.example.galleryapp.ui.callback.MovieCallback

class MoviePagingAdapter(private val movieCallback: MovieCallback) :
    PagingDataAdapter<Movie, MoviePagingAdapter.MyViewHolder>(DiffCallback) {


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
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.callback = movieCallback
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let { holder.bind(it) }
    }


    class MyViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movieItem = movie
        }

    }
}