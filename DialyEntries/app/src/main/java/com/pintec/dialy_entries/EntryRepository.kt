package com.pintec.dialy_entries

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class EntryRepository(private val entryDao: EntryDao) {

    val allEntries: Flow<List<Entry>> = entryDao.getAll()

    suspend fun insert(entry: Entry) {
        entryDao.insert(entry)
    }
}