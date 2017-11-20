package io.pavelshackih.yandextranslator.domain.main

import io.pavelshackih.yandextranslator.domain.AppLang
import io.pavelshackih.yandextranslator.domain.Interactor
import io.pavelshackih.yandextranslator.domain.Translate
import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import io.pavelshackih.yandextranslator.ext.di.inject
import io.reactivex.Single

class MainInteractor : Interactor {

    private val localRepository by inject<LocalRepository>()
    private val remoteRepository by inject<RemoteRepository>()

    fun translate(from: AppLang, to: AppLang, source: String): Single<Translate> {
        return if (source.isNotBlank()) {
            remoteRepository.translate(from, to, source)
                    .doOnSuccess { localRepository.save(from.code, source, System.currentTimeMillis()) }
        } else {
            Single.just(Translate(emptyList()))
        }
    }
}