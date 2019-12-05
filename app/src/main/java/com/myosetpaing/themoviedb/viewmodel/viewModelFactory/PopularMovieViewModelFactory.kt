package com.myosetpaing.themoviedb.viewmodel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myosetpaing.themoviedb.data.dataSource.PopularMovieDataSource
import com.myosetpaing.themoviedb.viewmodel.PopularMovieViewModel

class PopularMovieViewModelFactory(val popularMovieDataSource: PopularMovieDataSource) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PopularMovieViewModel(popularMovieDataSource) as T
    }

}