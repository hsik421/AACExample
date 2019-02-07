package com.mobile.app.aacexample.di

import com.mobile.app.aacexample.di.scope.ActivityScoped
import com.mobile.app.aacexample.ui.main.MainActivity
import com.mobile.app.aacexample.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [
        MainModule::class,
        DialogModule::class
    ])
    internal abstract fun mainActivity() : MainActivity
}