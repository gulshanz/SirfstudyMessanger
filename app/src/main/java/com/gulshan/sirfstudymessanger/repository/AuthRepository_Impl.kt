package com.gulshan.sirfstudymessanger.repository

import com.gulshan.sirfstudymessanger.network.api.AuthApi
import com.gulshan.sirfstudymessanger.network.response.LoginResponse
import com.gulshan.sirfstudymessanger.util.Constants.SERVER_KEY
import retrofit2.Response

class AuthRepository_Impl(
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun login(username: String, password: String): Response<LoginResponse> {
        return authApi.login(username, password, SERVER_KEY)
    }

    fun isLoggedIn(){

    }

}