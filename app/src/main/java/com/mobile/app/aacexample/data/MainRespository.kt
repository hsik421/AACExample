package com.mobile.app.aacexample.data

import com.mobile.app.aacexample.data.local.MainDao

class MainRespository private constructor(private val mainDao : MainDao){
    fun getMains() = mainDao.getMains()

    fun getMain(idx : Int) = mainDao.getMain(idx)

    companion object {
        @Volatile private var instance : MainRespository? = null

        fun getInstance(mainDao : MainDao) = instance ?: synchronized(this){
            instance ?: MainRespository(mainDao).also { instance = it }
        }
    }
}