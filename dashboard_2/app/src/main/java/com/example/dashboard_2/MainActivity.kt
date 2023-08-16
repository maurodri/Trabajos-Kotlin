package com.example.dashboard_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dashboard_2.components.MainPage
import com.example.dashboard_2.ui.theme.Dashboard_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dashboard_2Theme {
                MainPage()
            }
        }
    }
}
