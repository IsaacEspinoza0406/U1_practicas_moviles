package com.isaacespinoza.u4_examen_practico.data.api

import com.google.gson.annotations.SerializedName

data class SimpsonsDto(
    @SerializedName("quote") val quote: String?,
    @SerializedName("character") val character: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("characterDirection") val characterDirection: String?
)