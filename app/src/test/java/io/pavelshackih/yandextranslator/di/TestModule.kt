package io.pavelshackih.yandextranslator.di

import io.mockk.mockk
import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import io.pavelshackih.yandextranslator.domain.wrapper.PlatformWrapper
import org.koin.dsl.module.applicationContext

class TestModule {

    private val localRepository = mockk<LocalRepository>()
    private val remoteRepository = mockk<RemoteRepository>()
    private val platformWrapper = mockk<PlatformWrapper>()

    val testModule = applicationContext {
        provide { localRepository }
        provide { remoteRepository }
        provide { platformWrapper }
    }
}