package com.mobile.app.aacexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mobile.app.aacexample.data.MainRespository
import com.mobile.app.aacexample.data.local.Main
import com.mobile.app.aacexample.util.SingleLiveEvent

class MainViewModel internal constructor(private val mainRepository : MainRespository) : ViewModel(){

    val mainList : LiveData<List<Main>> = mainRepository.getMains()
    val snackbarMessage = SingleLiveEvent<String>()
    fun insert(text : String){
        mainRepository.insertMain(Main(0,text))
                .doOnSuccess {
                    snackbarMessage.value = "insert success"
                }
                .doOnError {
                    snackbarMessage.value = "insert error"
                }.subscribe()
    }

    fun onUpdateClick(pos : Int){

    }

    fun onDeleteClick(pos : Int){
        mainRepository.removeMain(mainList.value?.get(pos)?:return)
                .doOnSuccess {
                    snackbarMessage.value = "delete success"
                }
                .doOnError {
                    snackbarMessage.value = "delete error"
                }.subscribe()
    }
}