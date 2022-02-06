package com.gulshan.sirfstudymessanger.network.api

import com.gulshan.sirfstudymessanger.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("api/auth/")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("server_key") server_key: String
    ): Response<LoginResponse>
}