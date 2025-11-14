package com.isaacespinoza.scores_unidad3.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.isaacespinoza.scores_unidad3.data.Student

@Composable
fun Dashboard(students: MutableList<Student>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(students.toList()) { student ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "${student.name} ${student.lastName}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text("Grado: ${student.grade}")
                        Text("Grupo: ${student.group}")
                    }

                    IconButton(onClick = {
                        students.remove(student)
                    }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun views(students: MutableList<Student>) {
    var vistaSeleccionada by remember { mutableIntStateOf(0) }

    Column {
        TabRow(selectedTabIndex = vistaSeleccionada) {
            Tab(
                selected = vistaSeleccionada == 0,
                onClick = { vistaSeleccionada = 0 },
                text = { Text("Dashboard") }
            )
            Tab(
                selected = vistaSeleccionada == 1,
                onClick = { vistaSeleccionada = 1 },
                text = { Text("Edit") }
            )
            Tab(
                selected = vistaSeleccionada == 2,
                onClick = { vistaSeleccionada = 2 },
                text = { Text("Add") }
            )
        }

    }
}