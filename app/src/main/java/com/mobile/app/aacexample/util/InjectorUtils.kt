package com.mobile.app.aacexample.util

import android.content.Context
import com.mobile.app.aacexample.data.MainRespository
import com.mobile.app.aacexample.data.local.AppDatabase
import com.mobile.app.aacexample.ui.main.MainViewModel
import com.mobile.app.aacexample.ui.main.MainViewModelFactory

object InjectorUtils {
    private fun getMainRepository(context : Context) : MainRespository{
        return MainRespository.getInstance(AppDatabase.getInstance(context).mainDao())
    }


    fun provideMainViewModelFactory(context: Context) : MainViewModelFactory{
        val repository = getMainRepository(context)
        return MainViewModelFactory(repository)
    }
}