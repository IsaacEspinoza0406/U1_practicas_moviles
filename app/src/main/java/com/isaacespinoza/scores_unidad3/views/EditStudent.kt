package com.isaacespinoza.scores_unidad3.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.isaacespinoza.scores_unidad3.data.Student

@Composable
fun EditStudent(students: MutableList<Student>) {
    var selectedStudent by remember { mutableStateOf<Student?>(null) }
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }
    var group by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(students) { student ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedStudent = student
                            name = student.name
                            lastName = student.lastName
                            grade = student.grade
                            group = student.group
                            score = student.score.toString()
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("${student.name} ${student.lastName}")
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            }
        }

        selectedStudent?.let { student ->
            Divider()

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("LastName") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = grade,
                onValueChange = { grade = it },
                label = { Text("Grade") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = group,
                onValueChange = { group = it },
                label = { Text("Group") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = score,
                onValueChange = { score = it },
                label = { Text("Score") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val index = students.indexOf(student)
                    if (index != -1) {
                        students[index] = Student(
                            id = student.id,
                            name = name,
                            lastName = lastName,
                            grade = grade,
                            group = group,
                            score = score.toDoubleOrNull() ?: 0.0
                        )
                        selectedStudent = null
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save.")
            }
        }
    }
}