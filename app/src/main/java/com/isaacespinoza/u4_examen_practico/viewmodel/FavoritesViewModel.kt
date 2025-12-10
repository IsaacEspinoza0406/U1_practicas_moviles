package com.isaacespinoza.u4_examen_practico.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isaacespinoza.u4_examen_practico.db.entity.FavoriteEntity
import com.isaacespinoza.u4_examen_practico.favorites.FavoriteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repo: FavoriteRepository) : ViewModel() {
    // Exponer flow de favoritos
    val favoritesState: StateFlow<List<FavoriteEntity>> = repo.getAllFavorites()
        .map { it }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addFavorite(entity: FavoriteEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch {
            repo.addFavorite(entity)
            onComplete?.invoke()
        }
    }

    fun removeFavorite(entity: FavoriteEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch {
            repo.removeFavorite(entity)
            onComplete?.invoke()
        }
    }
}