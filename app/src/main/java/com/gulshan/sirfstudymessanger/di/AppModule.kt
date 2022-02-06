package com.gulshan.sirfstudymessanger.di

import android.content.Context
import com.gulshan.sirfstudymessanger.ApplicationClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): ApplicationClass {
        return app as ApplicationClass
    }
}