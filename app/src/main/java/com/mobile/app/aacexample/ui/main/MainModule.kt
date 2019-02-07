package com.mobile.app.aacexample.ui.main

import androidx.lifecycle.ViewModel
import com.mobile.app.aacexample.data.MainRespository
import com.mobile.app.aacexample.data.local.MainDao
import com.mobile.app.aacexample.di.scope.FragmentScoped
import com.mobile.app.aacexample.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment() : MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainFragmentViewModel(viewModel : MainViewModel) : ViewModel

    
}