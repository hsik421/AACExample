package com.mobile.app.aacexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

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

//    @Query("UPDATE aac_table SET title=:title WHERE idx = :idx")
    @Update(onConflict = REPLACE)
    fun updateMain(main : Main)
}