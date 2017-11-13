package io.pavelshackih.yandextranslator

import io.pavelshackih.yandextranslator.ext.rx.RxScheduler
import io.pavelshackih.yandextranslator.ext.rx.RxSchedulerImpl
import org.koin.dsl.context.Context
import org.koin.dsl.module.Module

class MainModule : Module() {
    override fun context(): Context = applicationContext {
        provide { RxSchedulerImpl() } bind RxScheduler::class
    }
}