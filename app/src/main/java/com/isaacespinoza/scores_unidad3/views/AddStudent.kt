package com.isaacespinoza.scores_unidad3.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.isaacespinoza.scores_unidad3.data.Student

@Composable
fun agregarStudent(students: MutableList<Student>) {
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }
    var group by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
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
                if (name.isNotBlank()) {
                    students.add(
                        Student(
                            id = (students.maxOfOrNull { it.id } ?: 0) + 1,
                            name = name,
                            lastName = lastName,
                            grade = grade,
                            group = group,
                            score = score.toDoubleOrNull() ?: 0.0
                        )
                    )
                    name = ""
                    lastName = ""
                    grade = ""
                    group = ""
                    score = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Add student.")
        }
    }
}
