package com.mobile.app.aacexample.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.mobile.app.aacexample.data.MainRespository
import com.mobile.app.aacexample.data.local.Main
import com.mobile.app.aacexample.util.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository : MainRespository) : ViewModel(){

    private val _test = MediatorLiveData<List<Main>>()
    val test : LiveData<List<Main>>
        get() = _test


    init {
        _test.addSource(mainRepository.getMains()) { data->
            Log.i("hsik","data = $data")
            _test.value = data
        }
    }


//    val mainList : LiveData<List<Main>> = mainRepository.getMains()
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
        mainRepository.removeMain(test.value?.get(pos)?:return)
                .doOnSuccess {
                    snackbarMessage.value = "delete success"
                }
                .doOnError {
                    snackbarMessage.value = "delete error"
                }.subscribe()
    }
}