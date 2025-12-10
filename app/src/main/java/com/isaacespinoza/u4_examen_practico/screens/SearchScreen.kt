package com.isaacespinoza.u4_examen_practico.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.isaacespinoza.u4_examen_practico.data.api.SimpsonsDto
import com.isaacespinoza.u4_examen_practico.viewmodel.*
import com.isaacespinoza.u4_examen_practico.db.entity.FavoriteEntity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    itemsViewModel: ItemsViewModel,
    favoritesViewModel: FavoritesViewModel,
    onItemClick: (Int) -> Unit,
    onOpenFavorites: () -> Unit
) {
    val state by itemsViewModel.uiState.collectAsState()
    
    val filtered = remember(state) {
        val q = state.query.trim().lowercase()
        if (q.isEmpty()) {
            state.items
        } else {
            state.items.filter {
                (it.character ?: "").lowercase().contains(q) ||
                (it.quote ?: "").lowercase().contains(q)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Simpsons - Buscar") },
                actions = {
                    IconButton(onClick = onOpenFavorites) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Favoritos")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            OutlinedTextField(
                value = state.query,
                onValueChange = { itemsViewModel.updateQuery(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                placeholder = { Text("Buscar por personaje o frase") }
            )

            if (state.loading) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            } else if (state.error != null) {
                Text(text = "Error: ${state.error}", color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.padding(12.dp))
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    itemsIndexed(filtered) { index, item ->
                        SearchItemRow(
                            index = index,
                            item = item,
                            onClick = { onItemClick(index) },
                            onToggleFavorite = { dto ->
                                // Guardamos en Room
                                val favorite = FavoriteEntity(
                                    quote = dto.quote ?: "",
                                    character = dto.character ?: "",
                                    image = dto.image
                                )
                                favoritesViewModel.addFavorite(favorite)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SearchItemRow(
    index: Int,
    item: SimpsonsDto,
    onClick: () -> Unit,
    onToggleFavorite: (SimpsonsDto) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 6.dp)
        .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = coil.request.ImageRequest.Builder(androidx.compose.ui.platform.LocalContext.current)
                    .data(item.image)
                    .crossfade(true)
                    .setHeader("User-Agent", "Mozilla/5.0")
                    .build(),
                contentDescription = item.character,
                modifier = Modifier.size(64.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = item.character ?: "Sin nombre", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.quote ?: "", maxLines = 3, style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = { onToggleFavorite(item) }) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favorito")
            }
        }
    }
}