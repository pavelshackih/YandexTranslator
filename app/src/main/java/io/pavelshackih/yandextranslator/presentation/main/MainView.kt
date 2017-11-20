package io.pavelshackih.yandextranslator.presentation.main

import io.pavelshackih.yandextranslator.ext.mvp.AppView

interface MainView : AppView {

    fun setModel(model: ViewModel)

    fun showErrorSameLang()

    fun setTranslations(list: List<String>)
}