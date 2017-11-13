package io.pavelshackih.yandextranslator.data.repository

import io.pavelshackih.yandextranslator.data.network.TranslatorRemoteApi
import io.pavelshackih.yandextranslator.domain.SupportedLang
import io.pavelshackih.yandextranslator.domain.Translate
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import io.reactivex.Single

class RemoteRepositoryImpl(private val api: TranslatorRemoteApi) : RemoteRepository {

    override fun translate(lang: SupportedLang, source: String): Single<Translate> {
        return api.translate(lang.code, source).map { Translate(it.text) }
    }
}