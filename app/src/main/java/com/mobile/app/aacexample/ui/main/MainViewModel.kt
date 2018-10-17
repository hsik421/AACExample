package com.mobile.app.aacexample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.mobile.app.aacexample.data.MainRespository
import com.mobile.app.aacexample.data.local.Main

class MainViewModel internal constructor(mainRepository : MainRespository) : ViewModel(){

    val mainList : LiveData<List<Main>> = mainRepository.getMains()

}