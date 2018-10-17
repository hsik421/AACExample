package com.mobile.app.aacexample.di

import android.arch.lifecycle.ViewModel
import com.mobile.app.aacexample.di.scope.DialogScoped
import com.mobile.app.aacexample.di.scope.ViewModelKey
import com.mobile.app.aacexample.ui.insert.InsertDialog
import com.mobile.app.aacexample.ui.insert.InsertViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class DialogModule {
    @DialogScoped
    @ContributesAndroidInjector
    internal abstract fun contributeInsertDialog() : InsertDialog

    @Binds
    @IntoMap
    @ViewModelKey(InsertViewModel::class)
    abstract fun bindInsertViewModel(viewModel : InsertViewModel) : ViewModel
}