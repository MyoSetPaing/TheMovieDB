package com.myosetpaing.themoviedb.data.dataSource

import androidx.lifecycle.MutableLiveData
import com.myosetpaing.themoviedb.data.vos.MovieVO
import com.myosetpaing.themoviedb.networks.response.MovieResponse
import io.reactivex.Observable

interface PopularMovieDataSource {
    var popularMovieList: MutableLiveData<Observable<MovieResponse>>
    fun fetchPopularMovieData(page: Int)
}