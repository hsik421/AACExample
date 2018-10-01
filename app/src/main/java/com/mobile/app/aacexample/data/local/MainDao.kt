package com.mobile.app.aacexample.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface MainDao {
    @Query("SELECT * FROM aac_table ORDER BY idx")
    fun getMains() : LiveData<List<Main>>

    @Query("SELECT * FROM aac_table WHERE idx = :idx")
    fun getMain(idx : Int) : LiveData<Main>

    @Insert
    fun insertMain(main : Main) : Long

    @Delete
    fun deleteMain(main : Main)
}