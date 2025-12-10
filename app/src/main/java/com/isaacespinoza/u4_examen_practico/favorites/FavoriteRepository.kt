package com.isaacespinoza.u4_examen_practico.favorites

import com.isaacespinoza.u4_examen_practico.db.dao.FavoriteDao
import com.isaacespinoza.u4_examen_practico.db.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val dao: FavoriteDao) {
    fun getAllFavorites(): Flow<List<FavoriteEntity>> = dao.getAllFavorites()

    suspend fun addFavorite(favorite: FavoriteEntity) = dao.insert(favorite)

    suspend fun removeFavorite(favorite: FavoriteEntity) = dao.delete(favorite)

    suspend fun findByQuote(quote: String) = dao.findByQuote(quote)
}