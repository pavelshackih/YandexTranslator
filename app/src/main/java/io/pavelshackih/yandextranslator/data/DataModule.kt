package io.pavelshackih.yandextranslator.data

import android.arch.persistence.room.Room
import android.content.Context
import io.pavelshackih.yandextranslator.data.local.HistoryDb
import io.pavelshackih.yandextranslator.data.network.TranslatorRemoteApi
import io.pavelshackih.yandextranslator.data.repository.LocalRepositoryImpl
import io.pavelshackih.yandextranslator.data.repository.RemoteRepositoryImpl
import org.koin.dsl.module.Module

class DataModule(private val context: Context) : Module() {

    override fun context() = applicationContext {
        provide { TranslatorRemoteApi.API }
        provide { createDb() }
        provide { LocalRepositoryImpl(get()) }
        provide { RemoteRepositoryImpl(get()) }
    }

    private fun createDb(): HistoryDb = Room.databaseBuilder(context, HistoryDb::class.java, "db").build()
}