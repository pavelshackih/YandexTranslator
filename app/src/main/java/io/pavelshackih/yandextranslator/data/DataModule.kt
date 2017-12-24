package io.pavelshackih.yandextranslator.data

import android.arch.persistence.room.Room
import android.content.Context
import io.pavelshackih.yandextranslator.data.local.HistoryDao
import io.pavelshackih.yandextranslator.data.local.HistoryDb
import io.pavelshackih.yandextranslator.data.network.TranslatorRemoteApi
import io.pavelshackih.yandextranslator.data.repository.LocalRepositoryImpl
import io.pavelshackih.yandextranslator.data.repository.RemoteRepositoryImpl
import io.pavelshackih.yandextranslator.data.wrapper.PlatformWrapperImpl
import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import io.pavelshackih.yandextranslator.domain.wrapper.PlatformWrapper
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

class DataModule(private val context: Context) : Module {

    override fun invoke() = applicationContext {
        provide { TranslatorRemoteApi.API } bind TranslatorRemoteApi::class
        provide { createDb().translationDao() } bind HistoryDao::class
        provide { LocalRepositoryImpl(get()) } bind LocalRepository::class
        provide { RemoteRepositoryImpl(get()) } bind RemoteRepository::class
        provide { PlatformWrapperImpl() } bind PlatformWrapper::class
    }.invoke()

    private fun createDb(): HistoryDb = Room.databaseBuilder(context, HistoryDb::class.java, "db").build()
}