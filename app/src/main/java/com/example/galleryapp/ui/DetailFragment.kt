package com.example.galleryapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.galleryapp.R
import com.example.galleryapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private var title: String? = null
    private var overview: String? = null
    private var release_date: String? = null
    private var language: String? = null
    private var id: Int? = null
    private var image: String? = null
    private var vote_average: Double? = null
    private var backdrop_path: String? = null
    private var count: Long? = null


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

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        binding.collapsingToolbar.title = title
        binding.overviewTv.text = overview
        binding.VoteTv.text = "$vote_average"
        binding.tvLanguage.append("Original Language  $language")

        val baseUrl = "http://image.tmdb.org/t/p/w500"
        val finalUrl = baseUrl + image
        Glide.with(requireActivity()).load(finalUrl).into(binding.fileImage)



        return binding.root
    }


}