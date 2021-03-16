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
import com.example.galleryapp.databinding.TVShowFragemntBinding
import com.example.galleryapp.ui.adapter.TVAdapter
import com.example.galleryapp.utils.Resource
import com.example.galleryapp.viewmodels.TVShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TVShowFragemnt : Fragment() {


    private val viewModel: TVShowViewModel by viewModels()
    private lateinit var binding: TVShowFragemntBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.t_v_show_fragemnt, container, false)
        binding.isConnected = true

        setupObservers()

        return binding.root
    }


    private fun setupObservers() {
        viewModel.movieTopRatedResponse.observe(viewLifecycleOwner, {

            it?.let { resource ->
                when (resource.status) {

                    Resource.Status.SUCCESS -> {

                        val tvAdapter = TVAdapter()

                        resource.data?.let {
                            tvAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopRatedTVSHOWS.adapter = tvAdapter

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
        viewModel.moviePopularResponse.observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {

                    Resource.Status.SUCCESS -> {

                        val tvAdapter = TVAdapter()

                        resource.data?.let {
                            tvAdapter.submitList(resource.data.results)
                            binding.recyclerPopularTVShows.adapter = tvAdapter

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
        viewModel.movieAiringTodayResponse.observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {

                    Resource.Status.SUCCESS -> {

                        val tvAdapter = TVAdapter()

                        resource.data?.let {
                            tvAdapter.submitList(resource.data.results)
                            binding.recyclerViewAiringToday.adapter = tvAdapter

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
        viewModel.movieOnTheAirResponse.observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {

                    Resource.Status.SUCCESS -> {

                        val tvAdapter = TVAdapter()

                        resource.data?.let {
                            tvAdapter.submitList(resource.data.results)
                            binding.recyclerViewCurrentlyAiringTVShows.adapter = tvAdapter

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
        viewModel.movieActionResponse.observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {

                    Resource.Status.SUCCESS -> {

                        val tvAdapter = TVAdapter()

                        resource.data?.let {
                            tvAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopAction.adapter = tvAdapter

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
        viewModel.movieTopCrimeResponse.observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        val tvAdapter = TVAdapter()

                        resource.data?.let {
                            tvAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopCrime.adapter = tvAdapter

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
        viewModel.movieTopComedyResponse.observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {

                    Resource.Status.SUCCESS -> {

                        val tvAdapter = TVAdapter()

                        resource.data?.let {
                            tvAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopComedy.adapter = tvAdapter

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
        viewModel.movieTopWarResponse.observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {

                    Resource.Status.SUCCESS -> {

                        val tvAdapter = TVAdapter()

                        resource.data?.let {
                            tvAdapter.submitList(resource.data.results)
                            binding.recyclerViewTopWar.adapter = tvAdapter

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