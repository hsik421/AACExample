package com.mobile.app.aacexample.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(facory : MyViewModelFactory) : ViewModelProvider.Factory
}