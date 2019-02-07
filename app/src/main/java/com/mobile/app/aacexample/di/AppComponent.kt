package com.mobile.app.aacexample.di

import com.mobile.app.aacexample.MyApplication
import com.mobile.app.aacexample.data.MainRespository
import dagger.Component

import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            ViewModelModule::class,
            ActivityBindingModule::class
        ]
)
interface AppComponent :AndroidInjector<MyApplication>{
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()
}