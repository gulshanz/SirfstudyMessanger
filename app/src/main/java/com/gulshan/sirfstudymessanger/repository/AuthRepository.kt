package com.gulshan.sirfstudymessanger.repository

import com.gulshan.sirfstudymessanger.network.response.LoginResponse
import retrofit2.Response

interface AuthRepository {
    suspend fun login(username: String, password: String): Response<LoginResponse>
}