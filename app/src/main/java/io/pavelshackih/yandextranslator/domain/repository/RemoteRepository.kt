package io.pavelshackih.yandextranslator.domain.repository

import io.pavelshackih.yandextranslator.domain.AppLang
import io.pavelshackih.yandextranslator.domain.Translate
import io.reactivex.Single

interface RemoteRepository {

    fun translate(from: AppLang, to: AppLang, source: String): Single<Translate>
}