package com.pintec.dialy_entries

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entry::class], version = 1, exportSchema = false)
abstract class DailyEntriesDatabase : RoomDatabase() {

    abstract fun entryDao(): EntryDao

    companion object {

        private var INSTANCE: DailyEntriesDatabase? = null

        fun getDatabase(context: Context): DailyEntriesDatabase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                DailyEntriesDatabase::class.java,
                "daily_entries_db"
            ).build()
            INSTANCE = instance
            instance
        }

    }

}