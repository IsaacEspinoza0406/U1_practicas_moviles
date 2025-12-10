package com.isaacespinoza.u4_examen_practico.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonsService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("count") count: Int = 10): List<SimpsonsDto>
}