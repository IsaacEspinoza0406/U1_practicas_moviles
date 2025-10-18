package com.isaacespinoza.cuartitos_4a.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.isaacespinoza.cuartitos_4a.iu.add.AddStudentScreen
import com.isaacespinoza.cuartitos_4a.iu.dashboard.DashboardScreen
import com.isaacespinoza.cuartitos_4a.iu.details.DetailScreen
import com.isaacespinoza.cuartitos_4a.viewmodel.StudentViewModel

object Routes {
    const val DASHBOARD = "dashboard"
    const val ADD = "add"
    const val DETAILS = "details/{id}"
}

@Composable
fun NavManager(navController: NavHostController) {
    val studentViewModel: StudentViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.DASHBOARD) {
        composable(Routes.DASHBOARD) {
            DashboardScreen(navController, studentViewModel)
        }
        composable(Routes.ADD) {
            AddStudentScreen(navController, studentViewModel)
        }
        composable(Routes.DETAILS) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
            DetailScreen(navController, studentViewModel, id)
        }
    }
}
