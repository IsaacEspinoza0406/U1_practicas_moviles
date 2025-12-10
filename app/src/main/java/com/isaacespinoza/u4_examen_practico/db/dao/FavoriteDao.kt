package com.isaacespinoza.u4_examen_practico.db.dao

import androidx.room.*
import androidx.room.*
import com.isaacespinoza.u4_examen_practico.db.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favorite: FavoriteEntity): Long

    @Delete
    suspend fun delete(favorite: FavoriteEntity)

    @Query("SELECT * FROM favorites ORDER BY id DESC")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    @Query("SELECT * FROM favorites WHERE quote = :quote LIMIT 1")
    suspend fun findByQuote(quote: String): FavoriteEntity?
}