package com.example.basicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

// La clase MainActivity hereda de ComponentActivity
class MainActivity : ComponentActivity() {
    // Sobrescribe el método onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        // Llama al método onCreate de la superclase
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad
        setContent {
            // Utiliza el tema BasicStateCodelabTheme
            BasicStateCodelabTheme {
                // Crea una superficie que llena el tamaño máximo y tiene un color de fondo del esquema de color del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Muestra la pantalla de bienestar utilizando la función componible WellnessScreen
                    WellnessScreen()
                }
            }
        }
    }
}
