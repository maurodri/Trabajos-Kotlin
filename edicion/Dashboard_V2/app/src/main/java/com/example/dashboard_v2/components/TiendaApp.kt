package com.example.dashboard_v2.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dashboard_v2.pages.Login.LoginScreen
import com.example.dashboard_v2.pages.Login.animations.SplashScreen
import com.example.dashboard_v2.pages.Login.home.Pantallas


enum class PageScreen(){
    Login,
    DashBoard
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiendaApp(
    navController: NavHostController
) {

    Scaffold() { padding -> ScaffoldContent(
        padding = padding)
        NavHost(
            navController = navController,
            startDestination = Pantallas.SplashScreen.route
        ){
            composable(Pantallas.SplashScreen.route) {
                SplashScreen(navController)
            }
            composable(route = PageScreen.Login.name){
                LoginScreen(navController = navController)
            }
        }
    }
}

@Composable
fun ScaffoldContent(//1
    padding: PaddingValues,
) {
    Column(//(2)
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = padding.calculateBottomPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row { // (3)
        }
    }
}