package com.mobile.app.aacexample.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(facory : MyViewModelFactory) : ViewModelProvider.Factory
}