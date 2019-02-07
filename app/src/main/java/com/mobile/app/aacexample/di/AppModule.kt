package com.mobile.app.aacexample.di

import android.content.Context
import android.content.SharedPreferences
import com.mobile.app.aacexample.MyApplication
import com.mobile.app.aacexample.data.local.AppDatabase
import dagger.Module
import dagger.Provides


@Module
class AppModule {
    @Provides
    fun provideContext(application: MyApplication) : Context = application.applicationContext

    @Provides
    fun provideDatabase(application: MyApplication) : AppDatabase = AppDatabase.getInstance(application)


}