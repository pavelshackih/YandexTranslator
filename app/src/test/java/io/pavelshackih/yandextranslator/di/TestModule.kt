package io.pavelshackih.yandextranslator.di

import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import org.koin.dsl.context.Context
import org.koin.dsl.module.Module
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TestModule : Module() {

    @Mock
    lateinit var localRepostory: LocalRepository

    @Mock
    lateinit var remoteRepository: RemoteRepository

    init {
        MockitoAnnotations.initMocks(this)
    }

    override fun context(): Context = applicationContext {
        provide { localRepostory }
        provide { remoteRepository }
    }
}