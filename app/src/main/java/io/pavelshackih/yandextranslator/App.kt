package io.pavelshackih.yandextranslator

import android.app.Application
import io.pavelshackih.yandextranslator.data.DataModule
import io.pavelshackih.yandextranslator.domain.DomainModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(MainModule,
                DataModule(this),
                DomainModule()))
    }
}
