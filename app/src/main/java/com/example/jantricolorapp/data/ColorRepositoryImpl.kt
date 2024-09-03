package com.example.jantricolorapp.data

import kotlinx.coroutines.flow.Flow

class ColorRepositoryImpl(
    private val dao: ColorDao,
): ColorRepository {
    override fun getPendingColors(): Flow<List<Color>> {
        return dao.getPendingColors()
    }

    override suspend fun insertColor(color: Color) {
        dao.insertColor(color)
    }

    override fun getAllColors(): Flow<List<Color>> {
        return dao.getAllColors()
    }

    override suspend fun markAsSynced(id: Int) {
        dao.markAsSynced(id)
    }

}