package com.isaacespinoza.u4_examen_practico.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val quote: String,
    val character: String,
    val image: String?
)