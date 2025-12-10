package com.isaacespinoza.u4_examen_practico
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.isaacespinoza.u4_examen_practico.AppModule
import com.isaacespinoza.u4_examen_practico.AppNav
import com.isaacespinoza.u4_examen_practico.ui.theme.U4_examen_practicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppModule.init(this.applicationContext)

        setContent {
            U4_examen_practicoTheme {
                AppNav()
            }
        }
    }
}
