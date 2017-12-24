package io.pavelshackih.yandextranslator.domain.main

import io.mockk.every
import io.mockk.verify
import io.pavelshackih.yandextranslator.di.TestModule
import io.pavelshackih.yandextranslator.domain.AppLang
import io.pavelshackih.yandextranslator.domain.Translate
import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import io.pavelshackih.yandextranslator.domain.wrapper.PlatformWrapper
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.closeKoin
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest

class MainInteractorTest : KoinTest {

    private val remoteRepository: RemoteRepository by inject()
    private val localRepository: LocalRepository by inject()
    private val platformWrapper: PlatformWrapper by inject()

    private lateinit var interactor: MainInteractor

    @Before
    fun setUp() {
        startKoin(listOf(TestModule().testModule))
        interactor = MainInteractor()
    }

    @Test
    fun translate() {
        val fromLang = AppLang.EN
        val toLang = AppLang.RU
        val source = "test"
        val variants = listOf("1", "2", "3")
        val translate = Translate(variants)
        val time = 0L

        every { remoteRepository.translate(fromLang, toLang, source) }.returns(Single.just(translate))
        every { platformWrapper.getCurrentTime() }.returns(time)
        every { localRepository.save("en", source, time) }.returns(Completable.complete())

        val result = interactor.translate(fromLang, toLang, source).blockingGet()

        verify { localRepository.save(fromLang.code, source, time) }
        assertEquals(result, translate)
    }

    @After
    fun tearDown() {
        closeKoin()
    }
}