package com.isaacespinoza.u4_examen_practico.data.repository

import com.isaacespinoza.u4_examen_practico.data.api.RetrofitInstance
import com.isaacespinoza.u4_examen_practico.data.api.SimpsonsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemsRepository {
    suspend fun fetchSimpsons(count: Int = 10): Result<List<SimpsonsDto>> {
        return try {
            val result = withContext(Dispatchers.IO) {
                RetrofitInstance.api.getQuotes(count)
            }
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}