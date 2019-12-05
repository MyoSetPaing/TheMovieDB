package com.myosetpaing.themoviedb.networks.response

import com.google.gson.annotations.SerializedName
import com.myosetpaing.themoviedb.data.vos.MovieVO

data class MovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val total_results: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("results")
    val movieResponse: List<MovieVO>
)

