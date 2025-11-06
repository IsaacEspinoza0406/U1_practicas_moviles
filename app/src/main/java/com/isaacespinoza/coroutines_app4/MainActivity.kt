package com.isaacespinoza.coroutines_app4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.isaacespinoza.coroutines_app4.presentation.navegation.NavManager
import com.isaacespinoza.coroutines_app4.presentation.viewmodel.CoroutinesViewModel
import com.isaacespinoza.coroutines_app4.ui.theme.Coroutines_app4Theme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CoroutinesViewModel by viewModels()
            Coroutines_app4Theme {
                    NavManager(viewModel)
                }
            }
        }
    }

