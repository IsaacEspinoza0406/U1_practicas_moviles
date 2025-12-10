package com.isaacespinoza.u4_examen_practico

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.isaacespinoza.u4_examen_practico.screens.FavoritesScreen
import com.isaacespinoza.u4_examen_practico.screens.LoadingScreen
import com.isaacespinoza.u4_examen_practico.screens.SearchScreen
import com.isaacespinoza.u4_examen_practico.screens.ViewDetailsScreen
import com.isaacespinoza.u4_examen_practico.viewmodel.FavoritesViewModel
import com.isaacespinoza.u4_examen_practico.viewmodel.FavoritesViewModelFactory
import com.isaacespinoza.u4_examen_practico.viewmodel.ItemsViewModel
import com.isaacespinoza.u4_examen_practico.viewmodel.ItemsViewModelFactory

sealed class Screen(val route: String) {
    object Loading : Screen("loading")
    object Search : Screen("search")
    object Favorites : Screen("favorites")
    object Details : Screen("details/{index}") {
        fun createRoute(index: Int) = "details/$index"
    }
}

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Loading.route) {
        composable(Screen.Loading.route) {
            LoadingScreen(
                onLoaded = { navController.navigate(Screen.Search.route) }
            )
        }
        composable(Screen.Search.route) {
            val itemsVm: ItemsViewModel = viewModel(factory = ItemsViewModelFactory(AppModule.itemsRepository))
            val favoritesVm: FavoritesViewModel = viewModel(factory = FavoritesViewModelFactory(AppModule.favoriteRepository))
            SearchScreen(
                itemsViewModel = itemsVm,
                favoritesViewModel = favoritesVm,
                onItemClick = { index ->
                    navController.navigate(Screen.Details.createRoute(index))
                },
                onOpenFavorites = {
                    navController.navigate(Screen.Favorites.route)
                }
            )
        }
        composable(Screen.Details.route,
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            val idx = backStackEntry.arguments?.getInt("index") ?: 0
            val itemsVm: ItemsViewModel = viewModel(factory = ItemsViewModelFactory(AppModule.itemsRepository))
            val favoritesVm: FavoritesViewModel = viewModel(factory = FavoritesViewModelFactory(AppModule.favoriteRepository))
            ViewDetailsScreen(index = idx, itemsViewModel = itemsVm, favoritesViewModel = favoritesVm, onBack = { navController.popBackStack() })
        }

        composable(Screen.Favorites.route) {
            val favoritesVm: FavoritesViewModel = viewModel(factory = FavoritesViewModelFactory(AppModule.favoriteRepository))
            FavoritesScreen(favoritesViewModel = favoritesVm, onBack = { navController.popBackStack() })
        }
    }
}