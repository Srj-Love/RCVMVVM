package com.srjlove.rcvmvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.srjlove.rcvmvvm.IMoviesApi
import com.srjlove.rcvmvvm.R
import com.srjlove.rcvmvvm.factory.MoviesViewModelFactory
import com.srjlove.rcvmvvm.repository.MovieRepository
import com.srjlove.rcvmvvm.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private lateinit var mViewModel: MovieViewModel
    private lateinit var factory: MoviesViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val api = IMoviesApi()
        val repository = MovieRepository(api)


        //init viewmodel
        factory = MoviesViewModelFactory(repository)
        mViewModel = ViewModelProviders.of(requireActivity(), factory)[MovieViewModel::class.java]
    }
}