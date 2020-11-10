package com.example.galleryapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.galleryapp.R
import com.example.galleryapp.databinding.FragmentMoviesBinding
import com.example.galleryapp.ui.adapter.MovieAdapter
import com.example.galleryapp.utils.Resource
import com.example.galleryapp.viewmodels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MoviesFragment : Fragment() {


    private val viewModel: MoviesViewModel by viewModels()

    private lateinit var binding: FragmentMoviesBinding

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

                        val movieAdapter = MovieAdapter()

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

                        val movieAdapter = MovieAdapter()
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

                        val movieAdapter = MovieAdapter()

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

                        val movieAdapter = MovieAdapter()

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

                        val movieAdapter = MovieAdapter()

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

                        val movieAdapter = MovieAdapter()

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

                        val movieAdapter = MovieAdapter()

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