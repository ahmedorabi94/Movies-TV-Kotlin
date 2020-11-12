package com.example.galleryapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.galleryapp.R
import com.example.galleryapp.data.entity.Movie
import com.example.galleryapp.databinding.FragmentMoviesBinding
import com.example.galleryapp.ui.adapter.MovieAdapter
import com.example.galleryapp.ui.callback.MovieCallback
import com.example.galleryapp.utils.Resource
import com.example.galleryapp.viewmodels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MoviesFragment : Fragment() {


    private val viewModel: MoviesViewModel by viewModels()

    private lateinit var binding: FragmentMoviesBinding




    private val movieCallback = object : MovieCallback {
        override fun onClickMovie(movie: Movie) {
            val arguments = Bundle()
            arguments.putInt("id", movie.id)
            arguments.putString("title", movie.title)
            arguments.putString("image", movie.poster_path)
            arguments.putString("overview", movie.overview)
            arguments.putString("release_date", movie.release_date)
            arguments.putDouble("vote_average", movie.vote_average)
            arguments.putString("backdrop_path", movie.backdrop_path)
            arguments.putString("TYPE", "MOVIE_VALUE")
            arguments.putString("language", movie.original_language)
            arguments.putLong("count", movie.vote_count)

            Navigation.findNavController(binding.root)
                .navigate(R.id.action_moviesFragment_to_detailFragment, arguments)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_movies, container, false)


        binding.isConnected = true

        setupObservers()


        return binding.root
    }





    private fun setupObservers() {


        Timber.e("setupObservers")

        viewModel.getMovies().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        val movieAdapter = MovieAdapter(movieCallback)

                        resource.data?.let {
                            movieAdapter.submitList(resource.data.results)
                            binding.recyclerViewMain.adapter = movieAdapter
                        }


//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
//                        resource.data?.let { users -> retrieveList(users)
//                        }
                    }
                    Resource.Status.ERROR -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
//                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })


        viewModel.getPopularMovies().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        val movieAdapter = MovieAdapter(movieCallback)
                        resource.data?.let {

                            movieAdapter.submitList(resource.data.results)
                            binding.recyclerViewPopularMovies.adapter = movieAdapter

                        }


//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
//                        resource.data?.let { users -> retrieveList(users)
//                        }
                    }
                    Resource.Status.ERROR -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
//                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })


        viewModel.getTopRatedMovies().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        val movieAdapter = MovieAdapter(movieCallback)

                        resource.data?.let {
                            movieAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopRated.adapter = movieAdapter
                        }


//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
//                        resource.data?.let { users -> retrieveList(users)
//                        }
                    }
                    Resource.Status.ERROR -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
//                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })


        viewModel.getComingSoonMovies().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        val movieAdapter = MovieAdapter(movieCallback)

                        resource.data?.let {
                            movieAdapter.submitList(resource.data.results)
                            binding.recyclerViewUpComing.adapter = movieAdapter

                        }

                    }
                    Resource.Status.ERROR -> {

                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {

                    }
                }
            }
        })


        viewModel.getTopHorrorMovies().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        val movieAdapter = MovieAdapter(movieCallback)

                        resource.data?.let {
                            movieAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopHorrorMovies.adapter = movieAdapter

                        }

                    }
                    Resource.Status.ERROR -> {

                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {

                    }
                }
            }
        })

        viewModel.getTopActionMovies().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        val movieAdapter = MovieAdapter(movieCallback)

                        resource.data?.let {
                            movieAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopActionMovies.adapter = movieAdapter

                        }

                    }
                    Resource.Status.ERROR -> {

                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {

                    }
                }
            }
        })

        viewModel.getTopRomanceMovies().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        val movieAdapter = MovieAdapter(movieCallback)

                        resource.data?.let {
                            movieAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopRomanceMovies.adapter = movieAdapter

                        }

                    }
                    Resource.Status.ERROR -> {

                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {

                    }
                }
            }
        })

    }


}