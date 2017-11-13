package io.pavelshackih.yandextranslator

import android.app.Application
import io.pavelshackih.yandextranslator.data.DataModule
import org.koin.Koin
import org.koin.standalone.StandAloneContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        StandAloneContext.koinContext = Koin().build(
                MainModule(),
                DataModule(this)
        )
    }
}
