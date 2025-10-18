package com.isaacespinoza.cuartitos_4a.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.isaacespinoza.cuartitos_4a.data.Student

class StudentViewModel : ViewModel() {
    private val _students = mutableStateListOf<Student>()
    val students: List<Student> get() = _students

    fun addStudent(student: Student) {
        _students.add(student)
    }

    fun getStudentById(id: Int): Student? {
        return _students.find { it.id == id }
    }
}
