package com.example.galleryapp.ui

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.galleryapp.R
import com.example.galleryapp.databinding.FragmentSearchBinding
import com.example.galleryapp.ui.adapter.SearchAdapter
import com.example.galleryapp.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : Fragment() {


    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)

        val toolbar = binding.toolbarDisplay
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = ""


        setupObservers()
        return binding.root
    }


    private fun setupObservers() {

        viewModel.movies.observe(viewLifecycleOwner, { response ->
            response?.let {
                Timber.e(" ${it.results.size}")

                val adapter = SearchAdapter()
                adapter.submitList(it.results)
                binding.recyclerViewFilter.adapter = adapter

            }

        })


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.search_menu, menu)

        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager

        val searchView = menu.findItem(R.id.start_search).actionView as SearchView
        searchView.isIconifiedByDefault = false
        searchView.onActionViewExpanded()
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView.isSubmitButtonEnabled = true

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            val query = MutableStateFlow("")

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                query.value = newText

                viewModel.getMoviesTwo(newText)

                Timber.e(query.value)

                query.debounce(300)
                    .filter { query ->
                        if (query.isEmpty()) {
                            // adpter Empy
                            return@filter false
                        } else {
                            return@filter true
                        }
                    }
                    .distinctUntilChanged()
                    .flatMapLatest { query ->
                        Timber.e(query)
                        viewModel.getMovies(query)
                    }.flowOn(Dispatchers.Default)



                return true
            }


        })


    }


    fun SearchView.getQueryTextChangeStateFlow(): StateFlow<String> {

        val query = MutableStateFlow("")

        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                query.value = newText
                return true
            }
        })

        return query

    }


}