package io.pavelshackih.yandextranslator.presentation.main

import android.content.Context
import android.databinding.BindingAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import io.pavelshackih.yandextranslator.R
import io.pavelshackih.yandextranslator.domain.AppLang

object BindableAdapters {

    class AppLangAdapter(context: Context) : ArrayAdapter<AppLang>(context, R.layout.spinner_item) {

        private val inflater = LayoutInflater.from(context)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val result = convertView ?: inflater.inflate(R.layout.spinner_item, parent, false)
            val lang = getItem(position) as AppLang
            val textView = result as TextView
            textView.text = lang.code.toUpperCase()
            return result
        }
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("spinnerList", "selectedLang")
    fun convertSpinner(spinner: Spinner, list: List<AppLang>, selected: AppLang) {
        val context = spinner.context
        var adapter: AppLangAdapter? = spinner.adapter as AppLangAdapter?
        if (adapter == null) {
            adapter = AppLangAdapter(context)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            adapter.clear()
            adapter.addAll(list)
            spinner.adapter = adapter
        }
        spinner.setSelection(list.indexOf(selected))
    }
}