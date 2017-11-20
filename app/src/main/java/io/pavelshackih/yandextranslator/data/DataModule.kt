package io.pavelshackih.yandextranslator.data

import android.arch.persistence.room.Room
import android.content.Context
import io.pavelshackih.yandextranslator.data.local.HistoryDao
import io.pavelshackih.yandextranslator.data.local.HistoryDb
import io.pavelshackih.yandextranslator.data.network.TranslatorRemoteApi
import io.pavelshackih.yandextranslator.data.repository.LocalRepositoryImpl
import io.pavelshackih.yandextranslator.data.repository.RemoteRepositoryImpl
import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import org.koin.dsl.module.Module

class DataModule(private val context: Context) : Module() {

    override fun context() = applicationContext {
        provide { TranslatorRemoteApi.API } bind TranslatorRemoteApi::class
        provide { createDb().translationDao() } bind HistoryDao::class
        provide { LocalRepositoryImpl(get()) } bind LocalRepository::class
        provide { RemoteRepositoryImpl(get()) } bind RemoteRepository::class
    }

    private fun createDb(): HistoryDb = Room.databaseBuilder(context, HistoryDb::class.java, "db").build()
}