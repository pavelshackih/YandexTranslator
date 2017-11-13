package io.pavelshackih.yandextranslator.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(HistoryEntity::class), version = 1)
abstract class HistoryDb : RoomDatabase() {
    abstract fun translationDao(): HistoryDao
}
