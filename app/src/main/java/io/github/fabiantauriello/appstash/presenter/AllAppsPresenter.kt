package io.github.fabiantauriello.appstash.presenter

import androidx.lifecycle.LiveData
import io.github.fabiantauriello.appstash.model.App
import io.github.fabiantauriello.appstash.model.AppRepository
import io.github.fabiantauriello.appstash.model.RoomRepository

class AllAppsPresenter(private val repository: AppRepository = RoomRepository())
    : BasePresenter<AllAppsContract.View>(), AllAppsContract.Presenter {

    override fun getAllApps(): LiveData<List<App>> {
        return repository.getAllApps()
    }

    override fun clearAllApps() {
        repository.clearAllApps()
        getView()?.showAllAppsCleared()
    }

}