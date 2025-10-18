package com.isaacespinoza.cuartitos_4a.iu.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.isaacespinoza.cuartitos_4a.navigation.Routes
import com.isaacespinoza.cuartitos_4a.viewmodel.StudentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController, viewModel: StudentViewModel) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Routes.ADD) }) {
                Text("+", fontSize = 28.sp)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                "Student List.",
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(20.dp))

            if (viewModel.students.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("There are no students yet.", fontSize = 22.sp)
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                    items(viewModel.students) { student ->
                        Card(
                            onClick = { navController.navigate("details/${student.id}") },
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(8.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AsyncImage(
                                    model = student.image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(68.dp)
                                        .padding(end = 12.dp)
                                )
                                Column {
                                    Text(student.name, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                                    Text(student.description, fontSize = 26.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
