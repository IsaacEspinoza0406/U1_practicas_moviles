package com.isaacespinoza.examen_moviles.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isaacespinoza.examen_moviles.room.UserDao
import com.isaacespinoza.examen_moviles.room.UserEntity
import kotlinx.coroutines.launch

class FormViewModel(private val userDao: UserDao) : ViewModel() {

    fun insertUser(name: String, email: String) {
        viewModelScope.launch {
            userDao.insertUser(UserEntity(name = name, email = email))
        }
    }
}