package io.pavelshackih.yandextranslator.domain.main

import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.pavelshackih.yandextranslator.di.TestModule
import io.pavelshackih.yandextranslator.domain.SupportedLang
import io.pavelshackih.yandextranslator.domain.Translate
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.test.components.KoinTest
import org.koin.test.components.startContext

class MainInteractorTest : KoinTest {

    private val module = TestModule()
    private lateinit var interactor: MainInteractor

    @Before
    fun setUp() {
        startContext(module)
        interactor = MainInteractor()
    }

    @Test
    fun translate() {
        val lang = SupportedLang.RU
        val source = "test"
        val variants = listOf("1", "2", "3")
        val translate = Translate(variants)

        whenever(module.remoteRepository.translate(lang, source)).thenReturn(Single.just(translate))

        val result = interactor.translate(lang, source).blockingGet()

        verify(module.localRepostory).save(lang.code, source)
        assertEquals(result, translate)
    }
}