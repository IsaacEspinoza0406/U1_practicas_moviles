package com.isaacespinoza.coroutines_app4.presentation.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.isaacespinoza.coroutines_app4.presentation.viewmodel.CoroutinesViewModel

@Composable
fun NavManager(viewModel: CoroutinesViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "DashboardView"
    ){
        composable(
            "DashboardView"
        ){
            DashboardView(navController)
        }

        composable(
            "ButtonsView"
        ){
            ButtonsView(navController, viewModel)
        }

    }
}