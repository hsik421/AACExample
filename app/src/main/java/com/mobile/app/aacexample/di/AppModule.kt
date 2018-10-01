package com.mobile.app.aacexample.di

import android.content.Context
import com.mobile.app.aacexample.MyApplication
import dagger.Module
import dagger.Provides


@Module
class AppModule {
    @Provides
    fun provideContext(application: MyApplication) : Context = application.applicationContext
}