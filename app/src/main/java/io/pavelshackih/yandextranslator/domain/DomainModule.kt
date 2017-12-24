package io.pavelshackih.yandextranslator.domain

import io.pavelshackih.yandextranslator.domain.main.MainInteractor
import org.koin.dsl.context.Context
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

class DomainModule : Module {

    override fun invoke(): Context = applicationContext {
        provide { MainInteractor() }
    }.invoke()
}