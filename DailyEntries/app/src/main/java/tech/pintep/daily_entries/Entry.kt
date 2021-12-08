package tech.pintep.daily_entries

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entry(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val description: String
)