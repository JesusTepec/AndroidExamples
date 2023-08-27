package com.example.apptest.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apptest.repository.UserRepository
import com.example.apptest.viewmodel.LoginViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class LoginVMFactory @Inject constructor(var userRepository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return (LoginViewModel(userRepository) as T)
        }
        throw IllegalArgumentException("Unknown class name")
    }

}