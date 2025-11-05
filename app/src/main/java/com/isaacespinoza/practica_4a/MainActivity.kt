package com.isaacespinoza.practica_4a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.isaacespinoza.practica_4a.presentation.navigation.NavManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentAppTheme {
                val navController = rememberNavController()
                val studentViewModel: StudentViewModel = viewModel()

                NavHost(
                    navController = navController,
                    startDestination = "dashboard"
                ) {
                    composable("dashboard") {
                        DashboardScreen(navController, studentViewModel)
                    }
                    composable("add") {
                        AddStudentScreen(navController, studentViewModel)
                    }
                    composable("details/{id}") { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
                        DetailScreen(navController, studentViewModel, id)
                    }
                }
            }
        }
    }
}
