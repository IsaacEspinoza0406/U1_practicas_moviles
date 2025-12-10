package com.isaacespinoza.u4_examen_practico.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonsService {
    @GET("characters?limit=50")
    suspend fun getQuotes(): SimpsonsApiResponse
}