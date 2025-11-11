package com.isaacespinoza.examen_moviles.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)
    @Query("SELECT * FROM users")

    fun getAllUsers(): Flow<List<UserEntity>>
}