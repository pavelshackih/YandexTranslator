package io.pavelshackih.yandextranslator.ext.di

import io.pavelshackih.yandextranslator.domain.Interactor
import io.pavelshackih.yandextranslator.ext.mvp.AppPresenter
import org.koin.standalone.StandAloneContext

inline fun <reified T> Interactor.inject(name: String = ""): Lazy<T> = lazy { StandAloneContext.koinContext.get<T>(name) }

inline fun <reified T> AppPresenter<*>.inject(name: String = ""): Lazy<T> = lazy { StandAloneContext.koinContext.get<T>(name) }