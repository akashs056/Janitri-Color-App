package com.example.jantricolorapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {

    @Query("SELECT * FROM Color WHERE isSynced = 0")
    fun getPendingColors(): Flow<List<Color>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColor(color: Color)

    @Query("SELECT * from Color")
    fun getAllColors(): Flow<List<Color>>

    @Query("UPDATE Color SET isSynced = 1 WHERE id = :id")
    fun markAsSynced(id: Int)
}