package com.example.galleryapp.paging

import androidx.paging.PagingSource
import com.example.galleryapp.api.ApiService
import com.example.galleryapp.data.entity.Movie

class MoviePagingSource(private val apiService: ApiService) :
    PagingSource<Long, Movie>() {

    private val apiKey: String = "97c261053713fdbd691f42aa664c1463"


    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Movie> {

        return try {
            val nextPage = params.key ?: 1

            val response = apiService.getNowPlayingMoviesPaging(apiKey, nextPage)
            LoadResult.Page(
                data = response.body()!!.results,
                prevKey = if (nextPage == 1L) null else nextPage - 1,
                nextKey = response.body()!!.page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


}