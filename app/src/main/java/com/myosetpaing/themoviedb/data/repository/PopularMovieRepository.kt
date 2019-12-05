package com.myosetpaing.themoviedb.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.myosetpaing.themoviedb.data.dataSource.PopularMovieDataSource
import com.myosetpaing.themoviedb.networks.api.MovieApi
import com.myosetpaing.themoviedb.networks.response.MovieResponse
import io.reactivex.Observable

class PopularMovieRepository(private val context: Context, private val movieApi: MovieApi) :
    PopularMovieDataSource {

    override var popularMovieList: MutableLiveData<Observable<MovieResponse>> = MutableLiveData()


    override fun fetchPopularMovieData(page: Int) {
        popularMovieList.postValue(movieApi.getPopularMovie(page))
    }

}