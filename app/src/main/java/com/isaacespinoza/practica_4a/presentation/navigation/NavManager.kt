package com.isaacespinoza.practica_4a.presentation.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.isaacespinoza.practica_4a.presentation.views.DetailsViews

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(
        navController=navController,
        startDestination = "Home"
    ){
        composable("Home") {
            NavManager()
        }
        composable("Details/{id}", arguments = listOf(
            navArgument("id"){
                type = NavType.LongType
            }
        )) {
            val id = it.arguments?.getLong("id") ?: 0L
            DetailsViews(navController, id)
        }
    }
}