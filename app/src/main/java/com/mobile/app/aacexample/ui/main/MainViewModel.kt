package com.mobile.app.aacexample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import com.mobile.app.aacexample.data.local.Main
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel(){

    private val _mainLiveData = MediatorLiveData<List<Main>>()
    val mainLiveData : LiveData<List<Main>>
        get() = _mainLiveData

    init {
        _mainLiveData.addSource(mainLiveData) {
            _mainLiveData.value = _mainLiveData.value?.apply {

            } ?: emptyList()
        }
    }

    fun test(){
        mainLiveData.value = listOf<Main>(Main(1, "1"))
    }

}