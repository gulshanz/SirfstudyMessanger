package com.gulshan.sirfstudymessanger.di

import com.gulshan.sirfstudymessanger.network.api.AuthApi
import com.gulshan.sirfstudymessanger.network.api.ChatApi
import com.gulshan.sirfstudymessanger.repository.AuthRepository
import com.gulshan.sirfstudymessanger.repository.AuthRepository_Impl
import com.gulshan.sirfstudymessanger.repository.ChatRepository
import com.gulshan.sirfstudymessanger.repository.ChatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(
        api: AuthApi
    ): AuthRepository {
        return AuthRepository_Impl(api)
    }


    @Singleton
    @Provides
    fun provideChat(
        api: ChatApi
    ): ChatRepository {
        return ChatRepositoryImpl(api)
    }


}