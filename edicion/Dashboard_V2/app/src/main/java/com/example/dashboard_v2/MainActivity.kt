package com.example.dashboard_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.dashboard_v2.components.MainPage
import com.example.dashboard_v2.components.TiendaApp
import com.example.dashboard_v2.pages.Login.home.Navegacion
import com.example.dashboard_v2.ui.theme.Dashboard_V2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dashboard_V2Theme {
                // A surface container using the 'background' color from the theme
                Navegacion()
            }
        }
    }
}
