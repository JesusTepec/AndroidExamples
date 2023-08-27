package com.example.apptest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptest.model.LoginResponse
import com.example.apptest.repository.UserRepository
import com.pixplicity.easyprefs.library.Prefs
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class LoginViewModel @Inject constructor(var userRepository: UserRepository) : BaseViewModel() {

    fun login(email: String, password: String) : MutableLiveData<Boolean> {
        val reponseLiveData = MutableLiveData<Boolean>()
        userRepository.login(email, password).subscribeWith(object : DisposableSingleObserver<LoginResponse>() {
            override fun onSuccess(t: LoginResponse?) {
                t?.let { login ->
                    if(login.access_token.isNotEmpty()) {
                        saveDataSession(login.username, login.access_token)
                        reponseLiveData.postValue(true)
                    } else {
                        reponseLiveData.postValue(false)
                    }
                }
            }

            override fun onError(e: Throwable?) {
                reponseLiveData.postValue(false)
            }

        })
        return reponseLiveData
    }

    private fun saveDataSession(email: String, access_token: String) {
        sessionEmail = email
        sessionToken = access_token
    }

}