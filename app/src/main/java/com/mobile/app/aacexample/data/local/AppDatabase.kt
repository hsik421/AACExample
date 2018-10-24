package com.mobile.app.aacexample.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
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
