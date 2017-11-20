package io.pavelshackih.yandextranslator.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import io.pavelshackih.yandextranslator.R

class SimpleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val textView: TextView = view.findViewById(R.id.text_view)

    fun bind(text: String) {
        textView.text = text
    }
}