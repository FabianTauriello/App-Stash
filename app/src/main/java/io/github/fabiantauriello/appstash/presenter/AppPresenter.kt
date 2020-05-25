package io.github.fabiantauriello.appstash.presenter

import android.util.Log
import io.github.fabiantauriello.appstash.model.App
import io.github.fabiantauriello.appstash.model.AppRepository
import io.github.fabiantauriello.appstash.model.RoomRepository

class AppPresenter(private val repository: AppRepository = RoomRepository()) : BasePresenter<AppContract.View>(), AppContract.Presenter {
    // to keep track of an App's state in AppActivity
//    private lateinit var app: App

    private var name = ""
    private var platform = ""
    private var category = ""
    private var description = ""

    // called whenever the state of an app changes
    private fun updateApp() {
//        app = App(name, platform, category, description)
    }

    override fun updateName(name: String) {
        this.name = name
//        updateApp()
    }

    override fun platformSelected(platform: String) {
        this.platform = platform
//        updateApp()
    }

    override fun categorySelected(category: String) {
        this.category = category
//        updateApp()
    }

    override fun updateDescription(description: String) {
        this.description = description
//        updateApp()
    }

    override fun saveApp() {
        if (canSaveApp()) {
            repository.saveApp(App(name, platform, category, description))
            getView()?.showAppSaved()
        } else {
            Log.d("presenter", "NOT saving app")
            getView()?.showAppSaved()
        }
    }

    private fun canSaveApp(): Boolean {
        return name.isNotEmpty() && platform.isNotEmpty()
                && category.isNotEmpty() && description.isNotEmpty()
    }
}