package com.gulshan.sirfstudymessanger.network

import com.google.gson.GsonBuilder
import com.gulshan.sirfstudymessanger.network.api.AuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitHelper {
    private const val BASE_URL = "https://www.sirfstudy.com/"

    @Singleton
    @Provides
    fun provideAuthApi(): AuthApi {
        return getInstance().create(AuthApi::class.java)
    }

    val gson = GsonBuilder()
        .setLenient()
        .create()

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}