package com.gulshan.sirfstudymessanger.ui.auth

import SharedPref
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import com.gulshan.sirfstudymessanger.R
import com.gulshan.sirfstudymessanger.databinding.ActivityMainBinding
import com.gulshan.sirfstudymessanger.ui.home.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


        init()

    }

    fun init() {
        observe()
        binding.apply {
            buttonLogin.setOnClickListener {
                viewModel.login()
            }
        }
    }

    private fun observe() {
        viewModel.errorString.observe(this) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loginStatus.observe(this) {
            if (it) {
                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            }
        }
    }
}