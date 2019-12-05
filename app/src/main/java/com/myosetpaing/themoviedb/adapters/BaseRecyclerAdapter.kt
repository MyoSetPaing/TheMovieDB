package com.myosetpaing.themoviedb.adapters

import androidx.recyclerview.widget.RecyclerView
import com.myosetpaing.themoviedb.views.BaseViewHolder

abstract class BaseRecyclerAdapter<R : BaseViewHolder<D>, D : Any> : RecyclerView.Adapter<R>() {

    private var mDataList: MutableList<D> = ArrayList()

    override fun onBindViewHolder(viewHolder: R, position: Int) {
        viewHolder.setData(mDataList[position])
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    fun setData(newData: MutableList<D>) {
        mDataList = newData
        notifyDataSetChanged()
    }

    fun appendData(newData: List<D>) {
        mDataList.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): D? {
        return if (position < mDataList.size - 1) mDataList[position] else null

    }

    fun removeData(data: D) {
        mDataList.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: D) {
        mDataList.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mDataList = ArrayList()
        notifyDataSetChanged()
    }
}