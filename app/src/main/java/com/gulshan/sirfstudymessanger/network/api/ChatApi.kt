package com.gulshan.sirfstudymessanger.network.api

import com.gulshan.sirfstudymessanger.network.response.chats.AllChatsResponse
import com.gulshan.sirfstudymessanger.util.Constants.SERVER_KEY
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface ChatApi {

    @POST("get_chats")
    suspend fun getAllChats(
        @Field("access_token") access_token: String,
        @Field("server_key") server_key: String = SERVER_KEY
    ): Response<AllChatsResponse>
}