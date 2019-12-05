package com.myosetpaing.themoviedb.viewmodel

import androidx.lifecycle.MutableLiveData
import com.myosetpaing.themoviedb.data.dataSource.PopularMovieDataSource
import com.myosetpaing.themoviedb.data.vos.MovieVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PopularMovieViewModel(private val popularMovieDataSource: PopularMovieDataSource) :
    BaseViewModel() {
    private var page: Int = 1

    var errorState = MutableLiveData<String>()
    var successState = MutableLiveData<List<MovieVO>>()

    fun loadPopularMovieList() {
        popularMovieDataSource.popularMovieList.observeForever {
            launch {
                it.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        successState.postValue(it.movieResponse)
                    }, {
                        errorState.postValue(it.message)
                    })
            }
        }
        popularMovieDataSource.fetchPopularMovieData(page)
    }

}