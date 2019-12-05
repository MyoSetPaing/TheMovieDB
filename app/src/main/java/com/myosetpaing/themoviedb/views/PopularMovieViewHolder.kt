package com.myosetpaing.themoviedb.views

import android.view.View
import coil.api.load
import com.myosetpaing.themoviedb.R
import com.myosetpaing.themoviedb.data.vos.MovieVO
import kotlinx.android.synthetic.main.popularmovie_item_view.view.*


class PopularMovieViewHolder(itemView: View) : BaseViewHolder<MovieVO>(itemView) {

    override fun setData(data: MovieVO) {
        itemView.tvMovieTitle.text = data.title
        itemView.ivPoster.load("https://image.tmdb.org/t/p/w500${data.poster_path}") {
            placeholder(R.drawable.ic_launcher_background)
        }
    }

}
