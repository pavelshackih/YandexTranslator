package io.pavelshackih.yandextranslator.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * В задаче нужно было сохранять личный словарь для пользователя, но это
 * какая-то дичь поэтому я буду хранить локально историю запросов для языка.
 */
@Entity(tableName = "history")
data class HistoryEntity(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                         @ColumnInfo(name = "langCode") var langCode: String = "",
                         @ColumnInfo(name = "history") var history: String = "",
                         @ColumnInfo(name = "timeStamp") var timeStamp: Long = 0L)