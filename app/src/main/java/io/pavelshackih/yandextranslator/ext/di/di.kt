package io.pavelshackih.yandextranslator.ext.di

import org.koin.standalone.StandAloneContext

inline fun <reified T> Any.inject(name: String = "") = lazy { StandAloneContext.koinContext.get<T>(name) }