package com.mobile.app.aacexample.data

import com.mobile.app.aacexample.data.local.Main
import com.mobile.app.aacexample.data.local.MainDao
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRespository @Inject constructor(){
//    fun getMains() = mainDao.getMains()
//
//    fun getMain(idx : Int) = mainDao.getMain(idx)
//
//    fun createMain(main : Main) = Single.just(main)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .doOnSuccess { mainDao.insertMain(it) }
//
//    fun removeMain(main : Main) = Single.just(main)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .doOnSuccess { mainDao.deleteMain(it) }
//
//    fun updateMain(main : Main) = Single.just(main)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .doOnSuccess { mainDao.updateMain(it) }
//
//    companion object {
//        @Volatile private var instance : MainRespository? = null
//
//        fun getInstance(mainDao : MainDao) = instance ?: synchronized(this){
//            instance ?: MainRespository(mainDao).also { instance = it }
//        }
//    }
}