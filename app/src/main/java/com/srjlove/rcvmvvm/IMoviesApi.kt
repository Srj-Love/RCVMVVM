package com.srjlove.rcvmvvm

import com.srjlove.rcvmvvm.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IMoviesApi {

    companion object{
        operator fun invoke() : IMoviesApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(IMoviesApi::class.java)
        }
    }

    @GET("movies")
    suspend fun getMovies() : Response<List<Movie>>
}