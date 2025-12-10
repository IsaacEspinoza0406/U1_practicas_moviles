package com.isaacespinoza.u4_examen_practico.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.isaacespinoza.u4_examen_practico.data.repository.ItemsRepository

class ItemsViewModelFactory(private val repo: ItemsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemsViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}