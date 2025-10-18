package com.isaacespinoza.cuartitos_4a.iu.details

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.isaacespinoza.cuartitos_4a.viewmodel.StudentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, viewModel: StudentViewModel, studentId: Int) {
    val student = viewModel.getStudentById(studentId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Student details.", fontSize = 26.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text("<-", fontSize = 36.sp)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (student == null) {
                Text("Student not found.", fontSize = 26.sp)
            } else {
                AsyncImage(
                    model = student.image,
                    contentDescription = student.name,
                    modifier = Modifier
                        .size(180.dp)
                        .padding(bottom = 20.dp)
                )
                Text("ID: ${student.id}", fontSize = 30.sp)
                Text("Name: ${student.name}", fontSize = 30.sp)
                Text("Description: ${student.description}", fontSize = 30.sp)
            }
        }
    }
}
