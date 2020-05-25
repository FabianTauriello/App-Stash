package io.github.fabiantauriello.appstash.model

import androidx.lifecycle.LiveData
import androidx.room.*

// for accessing app objects in Room database
@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(app: App)

    @Delete
    fun clearApps(vararg app: App)

    @Query("SELECT * FROM app_idea_table ORDER BY name ASC")
    fun getAllApps(): LiveData<List<App>>
}