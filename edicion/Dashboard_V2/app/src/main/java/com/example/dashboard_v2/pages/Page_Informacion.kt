package com.example.dashboard_v2.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.dashboard_v2.R
data class Item(val imageResId: Int, val name: String, val price: Double)
@Composable
fun MyApp() {
    var cartItems by remember { mutableStateOf(listOf<Item>()) }

    // Mostrar la pantalla de productos
    Productos { item ->
        cartItems = cartItems + item
    }

    // Mostrar la pantalla del carrito con los elementos en la lista cartItems
    Carrito(cartItems) { item ->
        cartItems = cartItems - item
    }
}

@Composable
fun Productos(onAddToCart: (Item) -> Unit) {
    val items = listOf(
        Item(R.drawable.hv_huevos_aaa, "Huevo AAA", 12000.0),
        Item(R.drawable.hv_huevo_aa, "Huevo AA", 20000.0),
        Item(R.drawable.hv_huevob, "Huevo B", 34000.0),
        Item(R.drawable.ic_lacteos, "1Lb Queso", 12000.0),
        Item(R.drawable.lt_lacteo_4, "1L Leche", 2000.0),
        Item(R.drawable.ic_proteinas, "1K Carne", 24000.0)
    )

    LazyColumn {
        items(items) { item ->
            ItemCard(item) {
                onAddToCart(item)
            }

        }
        item {
            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}

@Composable
fun ItemCard(item: Item, onAdd: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(item.imageResId),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(RectangleShape)
            )
            Column {
                Text(item.name,maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body2)
                Text("$${item.price}")
            }
            Button(onClick = onAdd) {
                Text("Comprar")
            }
        }
    }
}
@Composable
fun Carrito(cartItems: List<Item>, onDelete: (Item) -> Unit) {
    val totalPrice = cartItems.sumByDouble { it.price }

    Box {

        Column {
            LazyColumn {
                items(cartItems) { item ->
                    ItemCard(item, "Delete") {
                        onDelete(item)
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(56.dp))
                }
            }
        }
        FloatingActionButton(
            onClick = { },
            content = {
                Text("Pagar: $${totalPrice}")
            },
            modifier = Modifier
                .padding(16.dp, bottom = 90.dp)
                .align(Alignment.BottomStart)
        )

    }
}

@Composable
fun ItemCard(item: Item, buttonText: String, onButtonClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(item.imageResId),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(RectangleShape)
            )
            Column {
                Text(item.name,maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body2)
                Text("$${item.price}")
            }
            Button(onClick = onButtonClick) {
                Text(buttonText)
            }
        }
    }
}