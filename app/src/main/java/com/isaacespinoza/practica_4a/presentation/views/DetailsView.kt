package com.isaacespinoza.practica_4a.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsViews(navController: NavHostController, id: Long) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Details")
                },
                actions = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ){
                        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ){
        DetailsContent(paddingValues = it, id)
    }
}

@Composable
fun DetailsContent(paddingValues: PaddingValues, id:Long){
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ){
        Text("Hello word $id.")
    }
}


