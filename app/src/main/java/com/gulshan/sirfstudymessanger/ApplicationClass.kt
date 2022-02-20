package com.gulshan.sirfstudymessanger

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // initializing shared preferences for any future use
        SharedPref.init(this)
    }
}