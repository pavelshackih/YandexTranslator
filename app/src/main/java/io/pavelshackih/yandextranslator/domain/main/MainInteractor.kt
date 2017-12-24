package io.pavelshackih.yandextranslator.domain.main

import io.pavelshackih.yandextranslator.domain.AppLang
import io.pavelshackih.yandextranslator.domain.Interactor
import io.pavelshackih.yandextranslator.domain.Translate
import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import io.pavelshackih.yandextranslator.domain.wrapper.PlatformWrapper
import io.reactivex.Single
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MainInteractor : Interactor, KoinComponent {

    private val localRepository by inject<LocalRepository>()
    private val remoteRepository by inject<RemoteRepository>()
    private val platformWrapper by inject<PlatformWrapper>()

    fun translate(from: AppLang, to: AppLang, source: String): Single<Translate> {
        return if (source.isNotBlank()) {
            remoteRepository.translate(from, to, source)
                    .doOnSuccess { localRepository.save(from.code, source, platformWrapper.getCurrentTime()) }
        } else {
            Single.just(Translate(emptyList()))
        }
    }
}