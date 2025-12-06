package com.isaacespinoza.intents_camera_app.views

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CameraScreen(viewModel: CameraViewModel = viewModel()) {
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        viewModel.onImageCaptured(bitmap)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mini app para tomar foto",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        if (viewModel.imageBitmap != null) {
            Image(
                bitmap = viewModel.imageBitmap!!.asImageBitmap(),
                contentDescription = "Se tomó la foto.",
                modifier = Modifier
                    .size(300.dp)
                    .padding(bottom = 16.dp)
            )
        } else {
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("No hay imagenes.")
            }
        }
        Button(
            onClick = {
                cameraLauncher.launch()
            }
        ) {
            Text("Abrir Cámara.")
        }
    }
}