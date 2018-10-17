package com.mobile.app.aacexample.ui.main

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import com.mobile.app.aacexample.data.MainRespository
import com.mobile.app.aacexample.data.local.Main
import javax.inject.Inject

class MainViewModel @Inject constructor(mainRepository : MainRespository) : ViewModel(){

    private val mainList = MediatorLiveData<List<Main>>()


    init {
//        mainList.addSource(mainRepository.getMains(),mainList::setValue)
    }

    fun getMains() = mainList

}