package io.pavelshackih.yandextranslator.data.repository

import io.pavelshackih.yandextranslator.data.network.TranslatorRemoteApi
import io.pavelshackih.yandextranslator.domain.AppLang
import io.pavelshackih.yandextranslator.domain.Translate
import io.pavelshackih.yandextranslator.domain.repository.RemoteRepository
import io.reactivex.Single

class RemoteRepositoryImpl(private val api: TranslatorRemoteApi) : RemoteRepository {

    override fun translate(from: AppLang, to: AppLang, source: String): Single<Translate> =
            api.translate("${from.code}-${to.code}", source).map { Translate(it.text) }
}