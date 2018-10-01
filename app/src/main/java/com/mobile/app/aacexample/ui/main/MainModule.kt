package com.mobile.app.aacexample.ui.main

import android.arch.lifecycle.ViewModel
import com.mobile.app.aacexample.di.FragmentScoped
import com.mobile.app.aacexample.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun mainFragment() : MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainFragmentViewModel(viewModel : MainViewModel) : ViewModel
}