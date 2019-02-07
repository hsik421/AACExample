package com.mobile.app.aacexample.data

import com.mobile.app.aacexample.data.local.AppDatabase
import com.mobile.app.aacexample.data.local.Main
import com.mobile.app.aacexample.data.local.MainDao
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class MainRespository @Inject constructor(){
    @Inject lateinit var database : AppDatabase

    fun getMains() = database.mainDao().getMains()

    fun getMain(idx : Int) = database.mainDao().getMain(idx)

    fun insertMain(main : Main) = Single.fromCallable { database.mainDao().insertMain(main) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { main.title.isNotEmpty() }

    fun removeMain(main : Main) = Single.fromCallable{ database.mainDao().deleteMain(main) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())


    fun updateMain(main : Main) = Single.fromCallable{ database.mainDao().updateMain(main) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}