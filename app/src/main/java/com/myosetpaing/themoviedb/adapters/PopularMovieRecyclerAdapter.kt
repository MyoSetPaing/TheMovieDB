package com.myosetpaing.themoviedb.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.themoviedb.R
import com.myosetpaing.themoviedb.data.vos.MovieVO
import com.myosetpaing.themoviedb.views.PopularMovieViewHolder

class PopularMovieRecyclerAdapter(val context: Context) :
    BaseRecyclerAdapter<PopularMovieViewHolder, MovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.popularmovie_item_view, parent, false)
        return PopularMovieViewHolder(view)
    }

}