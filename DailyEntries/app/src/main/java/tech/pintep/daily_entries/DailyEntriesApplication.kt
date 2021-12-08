package tech.pintep.daily_entries

import android.app.Application

class DailyEntriesApplication : Application() {

    val database by lazy { DailyEntriesDatabase.getDatabase(this) }

    val repository by lazy { EntryRepository(database.entryDao()) }

}