package com.isaacespinoza.u4_examen_practico.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.isaacespinoza.u4_examen_practico.favorites.FavoriteRepository

class FavoritesViewModelFactory(private val repo: FavoriteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoritesViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}