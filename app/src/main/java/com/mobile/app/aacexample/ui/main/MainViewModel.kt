package com.mobile.app.aacexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mobile.app.aacexample.data.MainRespository
import com.mobile.app.aacexample.data.local.Main

class MainViewModel internal constructor(private val mainRepository : MainRespository) : ViewModel(){

    val mainList : LiveData<List<Main>> = mainRepository.getMains()

    fun insert(text : String){
        mainRepository.insertMain(Main(0,text)).subscribe()
    }

    fun onUpdateClick(pos : Int){

    }

    fun onDeleteClick(pos : Int){
        mainRepository.removeMain(mainList.value?.get(pos)?:return).subscribe()
    }
}