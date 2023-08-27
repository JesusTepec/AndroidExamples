package com.example.apptest.model

data class LoginResponse(
    val username: String,
    val roles: List<String>,
    val token_type: String,
    val access_token: String,
    val expires_in: Long,
    val refresh_token: String
)