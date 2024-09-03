package com.example.jantricolorapp.data

import kotlinx.coroutines.flow.Flow

interface ColorRepository {

    fun getPendingColors(): Flow<List<Color>>

    suspend fun insertColor(color: Color)

    fun getAllColors(): Flow<List<Color>>

    suspend fun markAsSynced(id: Int)

}