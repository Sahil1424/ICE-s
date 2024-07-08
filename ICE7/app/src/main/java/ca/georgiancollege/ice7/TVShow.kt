package ca.georgiancollege.ice7

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_shows")
data class TVShow(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val genre: String,
    val rating: Double
)

