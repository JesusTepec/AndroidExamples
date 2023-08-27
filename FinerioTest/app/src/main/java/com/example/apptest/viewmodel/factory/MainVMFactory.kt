package com.example.apptest.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apptest.repository.MovementRepository
import com.example.apptest.repository.UserRepository
import com.example.apptest.viewmodel.LoginViewModel
import com.example.apptest.viewmodel.MainViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainVMFactory @Inject constructor(var userRepository: UserRepository, var movementRepository: MovementRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return (MainViewModel(userRepository, movementRepository) as T)
        }
        throw IllegalArgumentException("Unknown class name")
    }

}