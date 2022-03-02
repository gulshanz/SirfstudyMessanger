package com.gulshan.sirfstudymessanger.repository

import com.gulshan.sirfstudymessanger.network.response.chats.AllChatsResponse
import retrofit2.Response

interface ChatRepository {
    suspend fun getChats(): Response<AllChatsResponse>
}