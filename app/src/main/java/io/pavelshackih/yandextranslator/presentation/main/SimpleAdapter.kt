package io.pavelshackih.yandextranslator.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.pavelshackih.yandextranslator.R
import io.pavelshackih.yandextranslator.ext.view.inflate

class SimpleAdapter : RecyclerView.Adapter<SimpleViewHolder>() {

    val list: MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder =
            SimpleViewHolder(view = parent.inflate(R.layout.simple_view_holder))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SimpleViewHolder?, position: Int) {
        holder?.bind(list[position])
    }

    fun swapList(newList: List<String>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}