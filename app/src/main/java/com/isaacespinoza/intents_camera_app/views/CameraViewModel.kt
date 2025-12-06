package com.isaacespinoza.intents_camera_app.views

import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CameraViewModel : ViewModel() {
    var imageBitmap by mutableStateOf<Bitmap?>(null)
        private set
    fun onImageCaptured(bitmap: Bitmap?) {
        imageBitmap = bitmap
    }
}