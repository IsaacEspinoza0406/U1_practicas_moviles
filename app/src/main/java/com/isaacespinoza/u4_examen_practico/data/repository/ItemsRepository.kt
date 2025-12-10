package com.isaacespinoza.u4_examen_practico.data.repository

import com.isaacespinoza.u4_examen_practico.data.api.RetrofitInstance
import com.isaacespinoza.u4_examen_practico.data.api.SimpsonsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemsRepository {
    suspend fun fetchSimpsons(count: Int = 10): Result<List<SimpsonsDto>> {
        return try {
            val response = withContext(Dispatchers.IO) {
                RetrofitInstance.api.getQuotes()
            }
            val mapped = response.results.map { item ->
                val lowerName = item.name.lowercase()
                val imageUrl = when {
                    lowerName.contains("homer") -> "https://upload.wikimedia.org/wikipedia/en/0/02/Homer_Simpson_2006.png"
                    lowerName.contains("marge") -> "https://upload.wikimedia.org/wikipedia/en/0/0b/Marge_Simpson.png"
                    lowerName.contains("bart") -> "https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png"
                    lowerName.contains("lisa") -> "https://upload.wikimedia.org/wikipedia/en/e/ec/Lisa_Simpson.png"
                    lowerName.contains("maggie") -> "https://upload.wikimedia.org/wikipedia/en/9/9d/Maggie_Simpson.png"
                    lowerName.contains("burns") -> "https://upload.wikimedia.org/wikipedia/en/5/56/Mr_Burns.png"
                    lowerName.contains("ned flanders") -> "https://upload.wikimedia.org/wikipedia/en/8/84/Ned_Flanders.png"
                    lowerName.contains("moe") -> "https://upload.wikimedia.org/wikipedia/en/8/80/Moe_Szyslak.png"
                    lowerName.contains("milhouse") -> "https://upload.wikimedia.org/wikipedia/en/1/11/Milhouse_Van_Houten.png"
                    lowerName.contains("krusty") -> "https://static.wikia.nocookie.net/simpsons/images/e/e5/Krusty_The_Clown.png"
                    lowerName.contains("apu") -> "https://www.clipartmax.com/png/middle/117-1175736_apu-nahasapeemapetilon-apu-simpsons.png"
                    lowerName.contains("skinner") -> "https://upload.wikimedia.org/wikipedia/en/3/3a/Seymour_Skinner.png"
                    lowerName.contains("wiggum") -> "https://upload.wikimedia.org/wikipedia/en/c/c2/Chief_Wiggum.png"
                    lowerName.contains("ralph") -> "https://upload.wikimedia.org/wikipedia/en/1/14/Ralph_Wiggum.png"
                    lowerName.contains("abe") || lowerName.contains("grampa") -> "https://upload.wikimedia.org/wikipedia/en/3/3e/Abe_Simpson.png"
                    lowerName.contains("barney") -> "https://upload.wikimedia.org/wikipedia/en/d/de/Barney_Gumble.png"
                    lowerName.contains("lenny") -> "https://upload.wikimedia.org/wikipedia/en/6/69/Lenny_Leonard.png"
                    lowerName.contains("carl") -> "https://upload.wikimedia.org/wikipedia/en/8/8e/Carl_Carlson.png"
                    lowerName.contains("patty") -> "https://upload.wikimedia.org/wikipedia/en/f/f8/Patty_Bouvier.png"
                    lowerName.contains("selma") -> "https://upload.wikimedia.org/wikipedia/en/b/ba/Selma_Bouvier.png"
                    else -> "https://api.dicebear.com/9.x/bottts-neutral/png?seed=${item.name}"
                }

                SimpsonsDto(
                    quote = item.phrases?.firstOrNull() ?: item.occupation ?: "No quote",
                    character = item.name,
                    image = imageUrl,
                    characterDirection = "Right"
                )
            }
            Result.success(mapped)
        } catch (e: Exception) {
            val fallback = listOf(
                SimpsonsDto(quote = "D'oh!", character = "Homer Simpson", image = "https://upload.wikimedia.org/wikipedia/en/0/02/Homer_Simpson_2006.png", characterDirection = "Right"),
                SimpsonsDto(quote = "Eat my shorts!", character = "Bart Simpson", image = "https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png", characterDirection = "Right"),
                SimpsonsDto(quote = "Mmm~mm!", character = "Marge Simpson", image = "https://upload.wikimedia.org/wikipedia/en/0/0b/Marge_Simpson.png", characterDirection = "Right"),
                SimpsonsDto(quote = "If anyone wants me, I'll be in my room.", character = "Lisa Simpson", image = "https://upload.wikimedia.org/wikipedia/en/e/ec/Lisa_Simpson.png", characterDirection = "Right"),
                SimpsonsDto(quote = "*sucks pacifier*", character = "Maggie Simpson", image = "https://upload.wikimedia.org/wikipedia/en/9/9d/Maggie_Simpson.png", characterDirection = "Right")
            )
            Result.success(fallback)
        }
    }
}