package com.myosetpaing.themoviedb.networks.api

import com.myosetpaing.themoviedb.networks.response.MovieResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int?): Observable<MovieResponse>

}