package io.pavelshackih.yandextranslator.domain.repository

import io.reactivex.Completable
import io.reactivex.Single

interface LocalRepository {

    fun save(lang: String, history: String): Completable

    fun findByLang(lang: String): Single<List<String>>
}
