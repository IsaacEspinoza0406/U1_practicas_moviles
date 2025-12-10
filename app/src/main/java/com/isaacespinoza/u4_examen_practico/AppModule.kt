package com.isaacespinoza.u4_examen_practico

import android.content.Context
import androidx.room.Room
import com.isaacespinoza.u4_examen_practico.db.AppDatabase
import com.isaacespinoza.u4_examen_practico.favorites.FavoriteRepository
import com.isaacespinoza.u4_examen_practico.data.repository.ItemsRepository

object AppModule {
    lateinit var database: AppDatabase
    lateinit var favoriteRepository: FavoriteRepository
    lateinit var itemsRepository: ItemsRepository

    fun init(context: Context) {
        database = Room.databaseBuilder(context, AppDatabase::class.java, "favorites_db")
            .fallbackToDestructiveMigration()
            .build()
        favoriteRepository = FavoriteRepository(database.favoriteDao())
        itemsRepository = ItemsRepository()
    }
}