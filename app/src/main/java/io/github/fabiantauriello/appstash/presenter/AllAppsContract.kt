package io.github.fabiantauriello.appstash.presenter

import androidx.lifecycle.LiveData
import io.github.fabiantauriello.appstash.model.App

interface AllAppsContract {
    interface Presenter {
        fun getAllApps(): LiveData<List<App>>
        fun clearAllApps()
    }

    interface View {
        fun showAllAppsCleared()
    }
}