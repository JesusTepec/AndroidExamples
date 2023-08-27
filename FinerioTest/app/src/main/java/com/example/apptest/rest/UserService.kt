package com.example.apptest.rest

import com.example.apptest.model.LoginRequest
import com.example.apptest.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("login")
    fun login(
        @Body login: LoginRequest
    ): Single<LoginResponse>

}