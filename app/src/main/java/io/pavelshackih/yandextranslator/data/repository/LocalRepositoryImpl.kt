package io.pavelshackih.yandextranslator.data.repository

import io.pavelshackih.yandextranslator.data.local.HistoryDao
import io.pavelshackih.yandextranslator.data.local.HistoryEntity
import io.pavelshackih.yandextranslator.domain.repository.LocalRepository
import io.reactivex.Completable
import io.reactivex.Single

class LocalRepositoryImpl(private val dao: HistoryDao) : LocalRepository {

    override fun save(lang: String, history: String): Completable {
        return Completable.fromAction {
            dao.save(HistoryEntity(0, history, lang))
        }
    }

    override fun findByLang(lang: String): Single<List<String>> {
        return dao.findByLangCode(lang).map { entities -> entities.map { it.history } }
    }
}