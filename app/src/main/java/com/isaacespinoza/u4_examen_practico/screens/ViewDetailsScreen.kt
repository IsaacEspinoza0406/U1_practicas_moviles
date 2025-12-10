package com.isaacespinoza.u4_examen_practico.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.isaacespinoza.u4_examen_practico.data.api.SimpsonsDto
import com.isaacespinoza.u4_examen_practico.viewmodel.*
import com.isaacespinoza.u4_examen_practico.db.entity.FavoriteEntity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewDetailsScreen(
    index: Int,
    itemsViewModel: ItemsViewModel,
    favoritesViewModel: FavoritesViewModel,
    onBack: () -> Unit
) {
    val state by itemsViewModel.uiState.collectAsState()
    val items = state.items
    if (index < 0 || index >= items.size) {
        // invalid index: show message
        Scaffold(topBar = {
            TopAppBar(
                title = { Text("Detalle") },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.Filled.ArrowBack, "back") } }
            )
        }) { padding ->
            Box(modifier = Modifier.padding(padding).fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("Elemento no encontrado")
            }
        }
        return
    }

    val item: SimpsonsDto = items[index]

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(item.character ?: "Detalle") },
            navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.Filled.ArrowBack, contentDescription = "back") } }
        )
    }) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize()) {
            AsyncImage(model = item.image, contentDescription = item.character, modifier = Modifier.fillMaxWidth().height(250.dp))
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = item.character ?: "", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.quote ?: "", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(onClick = {
                    val fav = FavoriteEntity(quote = item.quote ?: "", character = item.character ?: "", image = item.image)
                    favoritesViewModel.addFavorite(fav)
                }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "guardar")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Guardar favorito")
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(onClick = { /* no-op: removal from details optional */ }) {
                    Icon(Icons.Filled.Share, contentDescription = "compartir")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Compartir")
                }
            }
        }
    }
}