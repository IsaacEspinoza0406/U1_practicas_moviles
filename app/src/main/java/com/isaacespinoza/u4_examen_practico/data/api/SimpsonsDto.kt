package com.isaacespinoza.u4_examen_practico.data.api

import com.google.gson.annotations.SerializedName

data class SimpsonsDto(
    @SerializedName("description") val quote: String?,
    @SerializedName("name") val character: String?,
    @SerializedName("thumbnailUrl") val image: String?,
    @SerializedName("characterDirection") val characterDirection: String?
)