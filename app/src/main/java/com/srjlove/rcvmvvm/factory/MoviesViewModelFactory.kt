package com.srjlove.rcvmvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.srjlove.rcvmvvm.repository.MovieRepository
import com.srjlove.rcvmvvm.viewmodel.MovieViewModel

/**
 * factory use for helping to passing data from Views
 */
@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(private val repository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(repository) as T // pass parameter here like this
    }
}