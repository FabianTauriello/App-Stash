package io.github.fabiantauriello.appstash.presenter

import androidx.annotation.DrawableRes

interface AppContract {
    // to be implemented by AppPresenter
    interface Presenter {
        // lets the view tell the presenter that a name has been entered
        fun updateName(name: String)
        // lets the view tell the presenter that a platform has been selected
        fun platformSelected(platform: String)
        // lets the view tell the presenter that a category has been selected
        fun categorySelected(category: String)
        // lets the view tell the presenter that a description has been entered
        fun updateDescription(description: String)
        fun saveApp()
    }

    // to be implemented by AppActivity
    interface View {
        fun showAppSaved()
        fun showAppSaveError()
    }
}