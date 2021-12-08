package tech.pintep.daily_entries

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entry: Entry)

    @Query("SELECT * FROM entry ORDER BY id")
    fun getAll(): Flow<List<Entry>>
}