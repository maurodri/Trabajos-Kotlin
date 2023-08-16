package com.example.cupcakes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cupcakes.ui.theme.CupcakesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CupcakesTheme {
                // A surface container using the 'background' color from the theme
               CupcakeApp()
            }
        }
    }
}