package com.example.galleryapp.api

import com.example.galleryapp.data.entity.MovieResponse
import com.example.galleryapp.data.entity.ReviewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    ///////////////////////////Movies///////////////////////////////////////
    @GET("movie/now_playing")
    suspend fun getNowPlayingMoviesAsync(@Query("api_key") apiKey: String): MovieResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMoviesPaging(
        @Query("api_key") apiKey: String,
        @Query("page") page: Long
    ): Response<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRated(@Query("api_key") apiKey: String): MovieResponse

    @GET("movie/upcoming")
    suspend fun getComingSoon(@Query("api_key") apiKey: String): MovieResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MovieResponse


    @GET("discover/movie")
    suspend fun getTopHorrorMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("include_adult") include_adult: String,
        @Query("include_video") include_video: String,
        @Query("vote_average.gte") vote1: String,
        @Query("vote_average.lte") lte: String,
        @Query("with_genres") genres: String
    ): MovieResponse

    @GET("discover/movie")
    suspend fun getTopActionMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("include_adult") include_adult: String,
        @Query("include_video") include_video: String,
        @Query("vote_average.gte") vote1: String,
        @Query("vote_average.lte") lte: String,
        @Query("with_genres") genres: String
    ): MovieResponse

    @GET("discover/movie")
    suspend fun getTopRomanceMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("include_adult") include_adult: String,
        @Query("include_video") include_video: String,
        @Query("vote_average.gte") vote1: String,
        @Query("vote_average.lte") lte: String,
        @Query("with_genres") genres: String
    ): MovieResponse
    ////////////////////////////////Movies//////////////////////////////////////////////////////////////


    ///////////////////////////TV Shows///////////////////////////////////////

    @GET("tv/top_rated")
    suspend fun getTopRatedTVSHOWS(@Query("api_key") apiKey: String): MovieResponse

    @GET("tv/popular")
    suspend fun getPopularTVSHOWS(@Query("api_key") apiKey: String): MovieResponse

    @GET("tv/airing_today")
    suspend fun getAiringTodayTVSHOWS(@Query("api_key") apiKey: String): MovieResponse


    @GET("tv/on_the_air")
    suspend fun getOnTheAirTVSHOWS(@Query("api_key") apiKey: String): MovieResponse


    @GET("discover/tv")
    suspend fun DiscoverTopTV(
        @Query("api_key") apiKey: String,
        @Query("vote_average.gte") vote1: String,
        @Query("with_genres") genres: String
    ): MovieResponse


////////////////////////////TV Shows//////////////////////////////////////////////


    //////////////Detail Fragment////////////////////////////////////////////////

    @GET("movie/{id}/reviews")
    suspend fun getReviewsMovies(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): ReviewResponse

    @GET("tv/{id}/reviews")
    suspend fun getReviewsTVs(@Path("id") id: Int, @Query("api_key") apiKey: String): ReviewResponse



    /////////////////////Detail Fragmnet/////////////////////////////////////////


    //////////////////Search///////////////////////
    @GET("search/multi")
    suspend fun searchMoviesApi(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): MovieResponse

    ////////////////Search///////////


}