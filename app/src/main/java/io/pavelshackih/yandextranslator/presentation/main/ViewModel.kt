package io.pavelshackih.yandextranslator.presentation.main

import android.databinding.BaseObservable
import io.pavelshackih.yandextranslator.BR
import io.pavelshackih.yandextranslator.domain.AppLang

data class ViewModel(
        var languages: List<AppLang> = ArrayList(),
        var fromLang: AppLang = AppLang.EN,
        var toLang: AppLang = AppLang.RU
) : BaseObservable() {

    fun switch() {
        val tmp = toLang
        toLang = fromLang
        fromLang = tmp
        refresh()
    }

    fun refresh() {
        notifyPropertyChanged(BR._all)
    }
}