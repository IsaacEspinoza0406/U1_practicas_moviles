package com.isaacespinoza.u4_examen_practico.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isaacespinoza.u4_examen_practico.data.repository.ItemsRepository
import com.isaacespinoza.u4_examen_practico.data.api.SimpsonsDto
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class ItemsUiState(
    val loading: Boolean = false,
    val items: List<SimpsonsDto> = emptyList(),
    val error: String? = null,
    val query: String = ""
)

class ItemsViewModel(private val repository: ItemsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(ItemsUiState(loading = true))
    val uiState: StateFlow<ItemsUiState> = _uiState.asStateFlow()

    init {
        fetchItems()
    }

    fun fetchItems(count: Int = 20) {
        _uiState.update { it.copy(loading = true, error = null) }
        viewModelScope.launch {
            val res = repository.fetchSimpsons(count)
            if (res.isSuccess) {
                val list = res.getOrNull() ?: emptyList()
                _uiState.update { it.copy(items = list, loading = false) }
            } else {
                _uiState.update { it.copy(error = res.exceptionOrNull()?.message ?: "Error", loading = false) }
            }
        }
    }

    fun updateQuery(q: String) {
        _uiState.update { it.copy(query = q) }
    }

    fun filteredItems(): List<SimpsonsDto> {
        val q = uiState.value.query.trim().lowercase()
        if (q.isEmpty()) return uiState.value.items
        return uiState.value.items.filter {
            (it.character ?: "").lowercase().contains(q) ||
                    (it.quote ?: "").lowercase().contains(q)
        }
    }
}