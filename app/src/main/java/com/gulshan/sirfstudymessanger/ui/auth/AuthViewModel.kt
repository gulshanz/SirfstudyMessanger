package com.gulshan.sirfstudymessanger.ui.auth

import SharedPref
import android.content.SharedPreferences
import android.icu.text.SymbolTable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gulshan.sirfstudymessanger.network.response.LoginResponse
import com.gulshan.sirfstudymessanger.repository.AuthRepository
import com.gulshan.sirfstudymessanger.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val loginStatus: MutableLiveData<Boolean> = MutableLiveData()
    val loginResponse: MutableLiveData<Boolean> = MutableLiveData()
    val errorString: MutableLiveData<String> = MutableLiveData();
    val username: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    fun login() {
        if (username.value.isNullOrBlank() || password.value.isNullOrBlank()) {
            errorString.value = "Username or password can't be empty"
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.login(username.value!!, password.value!!)
            if (response.isSuccessful) {
                val loginResponse = response.body() as LoginResponse
                if (!loginResponse.access_token.isNullOrEmpty()) {
                    saveAccessToken(loginResponse.access_token)
                    loginStatus.postValue(true)
                } else {
                    loginStatus.postValue(false)
                    showError()
                }
            } else {
                loginStatus.postValue(false)
                showError()
            }
        }
    }

    init {
        username.value = ""
        password.value = ""
        checkIsLoggedIn()
    }

    private fun showError() {
        // post value cause on background thread
        errorString.postValue("Error")
    }

    private fun saveAccessToken(accessToken: String) {
        SharedPref.write(Keys.PREFERENCE_AUTH_KEY, accessToken)
    }

    private fun checkIsLoggedIn(){
        val accessKey = SharedPref.read(Keys.PREFERENCE_AUTH_KEY, "")
        if (accessKey.isNullOrEmpty()) {
            loginStatus.postValue(false)
        } else {
            loginStatus.postValue(true)
        }
    }
}