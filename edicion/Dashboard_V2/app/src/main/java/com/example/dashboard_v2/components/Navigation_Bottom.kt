package com.example.dashboard_v2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dashboard_v2.pages.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@Composable
fun BottomMenu(
    navController: NavController,
    menu_items_bar: List<items_bar>
) {
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
    ) {
        BottomNavigation(
            modifier = Modifier.padding(
                0.dp,
                0.dp,
                60.dp,
                0.dp
            )
        ) {
            val currentRouteBar = Current_Route(navController = navController as NavHostController)
            menu_items_bar.forEach { item ->
                BottomNavigationItem(
                    selected = currentRouteBar == item.ruta,
                    onClick = { navController.navigate(item.ruta) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(item.title) }
                )
            }
        }
    }
}

@Composable
fun Fab(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController,
    cartItems: List<Item>
) {


    Box() {
        FloatingActionButton(onClick = { navController.navigate("carrito") }) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito")
        }
            Text(
                text = cartItems.size.toString(),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 12.dp, y = (-12).dp)
                    .background(Color.Green, CircleShape)
                    .padding(horizontal = 4.dp),
                color = Color(0xFF4CAF50),
                fontSize = 12.sp
            )

    }
}
