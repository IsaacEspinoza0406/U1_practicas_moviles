package com.isaacespinoza.u4_examen_practico.data.api

import com.google.gson.annotations.SerializedName

data class SimpsonsApiResponse(
    @SerializedName("results") val results: List<SimpsonsApiItem>
)

data class SimpsonsApiItem(
    @SerializedName("name") val name: String,
    @SerializedName("portrait_path") val portraitPath: String,
    @SerializedName("phrases") val phrases: List<String>?,
    @SerializedName("occupation") val occupation: String?
)
