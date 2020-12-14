package com.example.galleryapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.galleryapp.R
import com.example.galleryapp.data.entity.MovieType
import com.example.galleryapp.databinding.FragmentDetailBinding
import com.example.galleryapp.utils.Resource
import com.example.galleryapp.viewmodels.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    private var title: String? = null
    private var overview: String? = null
    private var release_date: String? = null
    private var language: String? = null
    private var id: Int? = null
    private var image: String? = null
    private var vote_average: Double? = null
    private var backdrop_path: String? = null
    private var count: Long? = null
    private var type: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            title = it.getString("title")
            overview = it.getString("overview")
            release_date = it.getString("release_date")
            language = it.getString("language")
            id = it.getInt("id")
            image = it.getString("image")
            vote_average = it.getDouble("vote_average")
            backdrop_path = it.getString("backdrop_path")
            count = it.getLong("count")
            type = it.getString("type")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.setMovieType(MovieType(id!!, type!!, -1))


        binding.collapsingToolbar.title = title
        binding.overviewTv.text = overview
        binding.VoteTv.text = "$vote_average"
        binding.tvLanguage.append("Original Language  $language")

        val baseUrl = "http://image.tmdb.org/t/p/w500"
        val finalUrl = baseUrl + image
        Glide.with(requireActivity()).load(finalUrl).into(binding.fileImage)


        setupObservers()

        return binding.root
    }


    private fun setupObservers() {

        viewModel.getReviews().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        Timber.e("SUCCESS")
                        resource.data?.let {
                            val reviewList = resource.data.results
                            val reviewItem = reviewList[0]
                            Timber.e(" $reviewItem")
                            viewModel.setReview(reviewItem)
                            viewModel.setReviewTwo(reviewItem)

                        }


                    }
                    Resource.Status.ERROR -> {
                        Timber.e("ERROR ${it.message}")

                    }
                    Resource.Status.LOADING -> {
                        Timber.e("LOADING")

                    }

                }
            }
        })

    }


}