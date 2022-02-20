package com.gulshan.sirfstudymessanger.ui.chat

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.gulshan.sirfstudymessanger.R
import com.gulshan.sirfstudymessanger.databinding.ChatScreenBinding

class ChatScreen : AppCompatActivity() {
    lateinit var binding: ChatScreenBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}