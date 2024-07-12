package com.example.demoeni.api

import com.example.demoeni.Movie
import com.example.demoeni.api.RetrofitTool.Companion.retrofit
import retrofit2.http.GET

interface MovieService {

    @GET("movies.json")
    suspend fun getMovies() : List<Movie>

    // Singleton
    object MovieApi {
        val movieService : MovieService by lazy {
            retrofit.create(MovieService::class.java);
        }
    }
}