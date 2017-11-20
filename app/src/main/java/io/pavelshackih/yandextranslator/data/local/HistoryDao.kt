package io.pavelshackih.yandextranslator.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface HistoryDao {

    @Query("select * from history")
    fun findAll(): Single<List<HistoryEntity>>

    @Query("select * from history WHERE langCode = :langCode order by timeStamp limit 10")
    fun findByLangCode(langCode: String): Single<List<HistoryEntity>>

    @Insert
    fun save(entity: HistoryEntity): Long

    @Delete
    fun delete(entity: HistoryEntity): Int
}
