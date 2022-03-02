package com.gulshan.sirfstudymessanger.network.response.chats

data class Details(
    val album_count: String,
    val followers_count: String,
    val following_count: String,
    val groups_count: String,
    val likes_count: String,
    val mutual_friends_count: Int,
    val post_count: String
)