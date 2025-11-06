package com.isaacespinoza.botones_app1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.isaacespinoza.botones_app1.presentation.NavManager.NavManager
import com.isaacespinoza.botones_app1.ui.theme.Botones_app1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Botones_app1Theme(darkTheme = true) {
                NavManager()
            }
        }
    }
}