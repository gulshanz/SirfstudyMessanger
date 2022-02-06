package com.gulshan.sirfstudymessanger.network.response

data class LoginResponse(
    val access_token: String,
    val api_status: Int,
    val timezone: String,
    val user_id: String
)