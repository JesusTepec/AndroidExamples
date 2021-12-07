package com.pintec.dialy_entries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EntryViewModel(private val repository: EntryRepository) : ViewModel() {

    val allEntries: LiveData<List<Entry>> = repository.allEntries.asLiveData()

    fun insert(entry: Entry) = viewModelScope.launch {
        repository.insert(entry)
    }

}