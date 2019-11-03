package com.srjlove.rcvmvvm.repository

import com.srjlove.rcvmvvm.IMoviesApi
import com.srjlove.rcvmvvm.network.SafeApiCall

class MovieRepository(private val api: IMoviesApi) : SafeApiCall() {

    suspend fun getMovies() = apiCall { api.getMovies() }
}