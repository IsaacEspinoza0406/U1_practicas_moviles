package com.isaacespinoza.scores_unidad3.scores

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.isaacespinoza.scores_unidad3.data.Student

@Composable
fun alumnoRezagado(estudiantes: List<Student>) {
    val alumnoMenorScore = estudiantes.minByOrNull { it.score }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (alumnoMenorScore != null) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Alumno con Mayor Rezago",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${alumnoMenorScore.name} ${alumnoMenorScore.lastName}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text("Grado: ${alumnoMenorScore.grade}")
                    Text("Grupo: ${alumnoMenorScore.group}")
                    Text(
                        text = "Score: %.2f".format(alumnoMenorScore.score),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        } else {
            Text(
                text = "No se encontrarón los estudiantes.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}