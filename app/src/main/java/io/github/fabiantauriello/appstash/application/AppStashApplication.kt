package io.github.fabiantauriello.appstash.application

import android.app.Application
import androidx.room.Room
import io.github.fabiantauriello.appstash.model.AppDatabase

class AppStashApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "app_database").build()
    }
}