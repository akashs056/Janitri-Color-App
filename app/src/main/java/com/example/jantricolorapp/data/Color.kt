package com.example.jantricolorapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Color(
    @ColumnInfo(name = "color")
    val color: String,
    @ColumnInfo(name = "timestamp")
    val timestamp: Long,
    @ColumnInfo(name = "isSynced")
    val isSynced: Boolean = false,
    @PrimaryKey val id:Int? = null
)
