package com.mobile.app.aacexample.data

import com.mobile.app.aacexample.data.local.Main
import com.mobile.app.aacexample.data.local.MainDao
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainRespository constructor(private val mainDao: MainDao){
    fun getMains() = mainDao.getMains()

    fun getMain(idx : Int) = mainDao.getMain(idx)

    fun insertMain(main : Main) = Single.fromCallable { mainDao.insertMain(main) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { main.title.isNotEmpty() }

    fun removeMain(main : Main) = Single.fromCallable{ mainDao.deleteMain(main) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())


    fun updateMain(main : Main) = Single.fromCallable{ mainDao.updateMain(main) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())


    companion object {
        @Volatile private var instance : MainRespository? = null

        fun getInstance(mainDao : MainDao) = instance ?: synchronized(this){
            instance ?: MainRespository(mainDao).also { instance = it }
        }
    }
}