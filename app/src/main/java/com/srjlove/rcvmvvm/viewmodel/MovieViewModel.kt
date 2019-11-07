package com.srjlove.rcvmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.srjlove.rcvmvvm.model.Movie
import com.srjlove.rcvmvvm.repository.MovieRepository

class MovieViewModel(
    private val repository: MovieRepository

) : ViewModel() {

    private val _moviesList = MutableLiveData<List<Movie>>() // private should not bwe expose

    val movie: LiveData<List<Movie>>
        get() = _moviesList


    suspend fun getMovies() {
        val movie = repository.getMovies()
        _moviesList.value = movie

    }
}