package io.pavelshackih.yandextranslator.domain

import io.pavelshackih.yandextranslator.domain.main.MainInteractor
import org.koin.dsl.context.Context
import org.koin.dsl.module.Module

class DomainModule : Module() {

    override fun context(): Context = applicationContext {
        provide { MainInteractor() }
    }
}