package com.myosetpaing.themoviedb.views

import androidx.recyclerview.widget.RecyclerView
import android.view.View


abstract class BaseViewHolder<W : Any>(itemView: View) : RecyclerView.ViewHolder(itemView){

    protected lateinit var mData: W


    abstract fun setData(data: W)
}