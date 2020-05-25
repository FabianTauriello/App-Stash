package io.github.fabiantauriello.appstash.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

// NOTE: I could have made a separate class for the App Room entity, and then provide mapping
// functions to convert between App and App entities, but for this simple app, I chose to make App
// an entity directly. In a bigger app, it would make sense for them to be separate and have a
// mapping layer between the model class and the repository

// this annotation is used to define a table in the Room database
@Entity(tableName = "app_idea_table")
data class App (
    @PrimaryKey @NonNull val name: String = "",
    val platform: String = "",
    val category: String = "",
    val description: String = ""
)