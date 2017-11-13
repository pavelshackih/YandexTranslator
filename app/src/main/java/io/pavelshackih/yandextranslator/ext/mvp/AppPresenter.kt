package io.pavelshackih.yandextranslator.ext.mvp

import com.arellomobile.mvp.MvpPresenter

abstract class AppPresenter<T: AppView> : MvpPresenter<T>()