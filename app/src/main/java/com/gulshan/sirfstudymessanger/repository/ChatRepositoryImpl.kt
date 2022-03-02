package com.gulshan.sirfstudymessanger.repository

import com.gulshan.sirfstudymessanger.network.api.ChatApi
import com.gulshan.sirfstudymessanger.network.response.chats.AllChatsResponse
import retrofit2.Response

class ChatRepositoryImpl(
    private val chatApi: ChatApi
) : ChatRepository {
    override suspend fun getChats(): Response<AllChatsResponse> {
        return chatApi.getAllChats()
    }
}