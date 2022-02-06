package com.gulshan.sirfstudymessanger.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gulshan.sirfstudymessanger.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}