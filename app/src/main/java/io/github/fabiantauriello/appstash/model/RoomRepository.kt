package io.github.fabiantauriello.appstash.model

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import io.github.fabiantauriello.appstash.application.AppStashApplication

// concrete implementation of AppRepository
class RoomRepository : AppRepository {

    private val appDao: AppDao = AppStashApplication.database.appDao()
    private val allApps: LiveData<List<App>>

    init {
        allApps = appDao.getAllApps()
    }

    override fun saveApp(app: App) {
        InsertAsyncTask(appDao).execute(app) // execute() calls doInBackground()
    }

    override fun getAllApps(): LiveData<List<App>> = allApps

    override fun clearAllApps() {
        val appArray = allApps.value?.toTypedArray()
        if (appArray != null) {
            DeleteAsyncTask(appDao).execute(*appArray) // spread operator (*) used to pass in all apps in array into varargs
        }
    }

    private class InsertAsyncTask internal constructor(private val dao: AppDao) : AsyncTask<App, Void, Void>() {
        override fun doInBackground(vararg params: App): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: AppDao) : AsyncTask<App, Void, Void>() {
        override fun doInBackground(vararg params: App): Void? {
            dao.clearApps(*params)
            return null
        }
    }

}