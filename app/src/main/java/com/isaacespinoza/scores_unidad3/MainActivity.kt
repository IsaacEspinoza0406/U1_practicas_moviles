package com.isaacespinoza.scores_unidad3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.isaacespinoza.scores_unidad3.data.Student
import com.isaacespinoza.scores_unidad3.ui.theme.Scores_unidad3Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scores_unidad3Theme {
                var tabSeleccionado by remember { mutableIntStateOf(0) }
                val students = remember { mutableStateListOf<Student>() }

                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text("Student System.") },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    }
                ) { paddingValues ->
                    Column(modifier = Modifier.padding(paddingValues)) {
                        TabRow(selectedTabIndex = tabSeleccionado) {
                            Tab(
                                selected = tabSeleccionado == 0,
                                onClick = { tabSeleccionado = 0 },
                                text = { Text("Add") }
                            )
                            Tab(
                                selected = tabSeleccionado == 1,
                                onClick = { tabSeleccionado = 1 },
                                text = { Text("Edit") }
                            )
                        }
                    }
                }
            }
        }
    }
}