package com.mobile.app.aacexample.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "aac_table")
data class Main(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idx")
        val idx : Int,
        @ColumnInfo(name = "title")
        val title : String
)