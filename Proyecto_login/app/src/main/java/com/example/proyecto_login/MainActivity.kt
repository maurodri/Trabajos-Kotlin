package com.example.proyecto_login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
//import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.proyecto_login.components.TiendaApp
import com.example.proyecto_login.pages.Navegacion
import com.example.proyecto_login.ui.theme.Proyecto_loginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_loginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Navegacion()
                }
            }
        }
        //Thread.sleep(1000)
        //screenSplash.setKeepOnScreenCondition{true}
        //val intent = Intent(this, DetailActivity::class.java)
        //startActivity(intent)
        //finish()
        /*val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnDrawListener(
            object : ViewTreeObserver.OnPreDrawListener{
                override fun onPreDraw(): Boolean {
                  return if(viewModel.isReady) {
                      content.viewTreeObserver.removeOnDrawListener (this)
                      true
                  }else {
                      false
                  }
                }
            }
        )*/
    }
}