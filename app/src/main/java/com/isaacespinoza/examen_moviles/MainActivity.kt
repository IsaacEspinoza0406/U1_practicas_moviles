package com.isaacespinoza.examen_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.isaacespinoza.examen_moviles.dataStore.StoreDarkMode
import com.isaacespinoza.examen_moviles.navigation.NavManager
import com.isaacespinoza.examen_moviles.ui.theme.Examen_movilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val darkModeStore = StoreDarkMode(this)

        setContent {
            val darkMode = darkModeStore.getDarkMode.collectAsState(initial = false)
            val navController = rememberNavController()

            Examen_movilesTheme(darkTheme = darkMode.value) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(navController, darkModeStore)
                }
            }
        }
    }
}
