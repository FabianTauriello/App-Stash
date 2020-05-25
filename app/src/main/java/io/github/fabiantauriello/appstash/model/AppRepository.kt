package io.github.fabiantauriello.appstash.model

import androidx.lifecycle.LiveData

// Here, I use an interface for the repository in part because it would simplify switching
// to a different concrete repository (other than Room), if I needed to later in the project lifecycle
interface AppRepository {
    fun saveApp(app: App)
    fun getAllApps(): LiveData<List<App>>
    fun clearAllApps()
}