package io.pavelshackih.yandextranslator.domain.main

import io.pavelshackih.yandextranslator.domain.SupportedLang
import io.pavelshackih.yandextranslator.domain.Translate
import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import io.pavelshackih.yandextranslator.ext.di.inject
import io.reactivex.Single

class MainInteractor {

    private val localRepository by inject<LocalRepository>()
    private val remoteRepository by inject<RemoteRepository>()

    fun translate(lang: SupportedLang, source: String): Single<Translate> {
        return remoteRepository.translate(lang, source)
                .doOnSuccess { localRepository.save(lang.code, source) }
    }
}