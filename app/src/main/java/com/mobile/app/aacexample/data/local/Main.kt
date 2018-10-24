package com.mobile.app.aacexample.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aac_table")
data class Main(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idx")
        val idx : Int,
        @ColumnInfo(name = "title")
        var title : String
)