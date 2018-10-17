package com.mobile.app.aacexample.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [(Main::class)],version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun mainDao() : MainDao

    companion object {
        @Volatile private var instance : AppDatabase? = null
        fun getInstance(context : Context) : AppDatabase = instance ?: synchronized(this){
            instance ?: Room.databaseBuilder(context.applicationContext,AppDatabase::class.java, "acc_db").build()
        }


    }
}
