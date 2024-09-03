package com.example.jantricolorapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Color::class],
    version = 1,
    exportSchema = false
)
abstract class ColorDatabase: RoomDatabase() {
    abstract val dao: ColorDao
}