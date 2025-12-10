package com.isaacespinoza.u4_examen_practico.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.isaacespinoza.u4_examen_practico.db.entity.FavoriteEntity
import com.isaacespinoza.u4_examen_practico.db.dao.FavoriteDao

@Database(entities = [FavoriteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}