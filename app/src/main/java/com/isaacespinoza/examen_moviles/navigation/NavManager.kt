package com.isaacespinoza.examen_moviles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.isaacespinoza.examen_moviles.dataStore.StoreDarkMode
import com.isaacespinoza.examen_moviles.views.DashboardView
import com.isaacespinoza.examen_moviles.views.DarkModeScreen
import com.isaacespinoza.examen_moviles.views.FormView

@Composable
fun NavManager(navController: NavHostController, darkModeStore: StoreDarkMode) {
    NavHost(navController = navController, startDestination = "dashboard") {

        composable("dashboard") {
            DashboardView(navController)
        }

        composable("darkmode") {
            DarkModeScreen(
                navController = navController,
                darkModeStore = darkModeStore
            )
        }

        composable("form") {
            FormView(navController = navController)
        }
    }
}