package com.example.apptest.repository

import com.example.apptest.model.LoginRequest
import com.example.apptest.model.LoginResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import com.example.apptest.rest.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(var userService: UserService) {

    fun login(emial: String, password: String): Single<LoginResponse> {
        return userService.login(LoginRequest(emial, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}