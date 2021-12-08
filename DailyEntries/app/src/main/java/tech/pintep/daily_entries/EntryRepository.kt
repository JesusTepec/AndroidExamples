package tech.pintep.daily_entries

import kotlinx.coroutines.flow.Flow

class EntryRepository(private val entryDao: EntryDao) {

    val allEntries: Flow<List<Entry>> = entryDao.getAll()

    suspend fun insert(entry: Entry) {
        entryDao.insert(entry)
    }
}