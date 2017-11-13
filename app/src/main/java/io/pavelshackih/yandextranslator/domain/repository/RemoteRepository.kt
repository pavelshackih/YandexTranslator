package io.pavelshackih.yandextranslator.domain.repository

import io.pavelshackih.yandextranslator.domain.SupportedLang
import io.pavelshackih.yandextranslator.domain.Translate
import io.reactivex.Single

interface RemoteRepository {

    fun translate(lang: SupportedLang, source: String): Single<Translate>

}