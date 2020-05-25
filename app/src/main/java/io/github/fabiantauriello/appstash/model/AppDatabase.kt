package io.github.fabiantauriello.appstash.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(App::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}