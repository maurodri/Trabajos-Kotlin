package com.example.dashboard_v2.pages

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dashboard_v2.R
import com.example.dashboard_v2.components.MenuItem
import com.example.dashboard_v2.data.Recipe
import com.example.dashboard_v2.data.strawberryCake
import com.example.dashboard_v2.pages.Login.home.Navegacion2
import com.example.dashboard_v2.ui.AppBarCollapsedHeight
import com.example.dashboard_v2.ui.AppBarExpendedHeight
import com.example.dashboard_v2.ui.theme.DarkGray
import com.example.dashboard_v2.ui.theme.Dashboard_V2Theme
import com.example.dashboard_v2.ui.theme.Gray
import com.example.dashboard_v2.ui.theme.LightGray
import com.example.dashboard_v2.ui.theme.Pink
import com.example.dashboard_v2.ui.theme.Shapes
import com.example.dashboard_v2.ui.theme.Transparent
import com.example.dashboard_v2.ui.theme.White
import kotlin.math.max
import kotlin.math.min

/*
@Composable
fun Page_Principal() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    var iconColor by remember { mutableStateOf(Color.Gray) }
    if (showDialog) {
        AlertDialog(onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { }) {
                    Text(text = "Login")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Confirmar") },
            text = { Text(text = "Esto es un texto de prueba para el cuadro de dialogo xd") }
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .padding(4.dp, top = 8.dp, bottom = 120.dp)
                .clickable { }
                .fillMaxWidth(),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.height(IntrinsicSize.Min)) {
                Image(
                    painter = painterResource(id = R.drawable.principal),
                    contentDescription = "noticia4"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Tienda Sena CBA",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "La app tienda sena es una aplicación móvil que te permite comprar los productos que elaboran los aprendices y egresados del SENA en Colombia. Con esta app, puedes apoyar el emprendimiento y la economía naranja, al adquirir artículos de calidad y con valor agregado. Puedes encontrar productos de diferentes sectores, como artesanías, gastronomía y mas.\uD83D\uDECD️\uD83C\uDF81",
                        style = MaterialTheme.typography.body1,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box() {
                            Row() {
                                TextButton(onClick = { showDialog = true }) {
                                    Text(text = "Ver mas")
                                }
                            }
                        }
                        Box() {
                            Row() {
                                Text(text = "12.4K")
                                IconButton(onClick = { iconColor = Color.Green }) {
                                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite", tint = iconColor)
                                }
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.Filled.Share,
                                        contentDescription = "Share"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Page_PrincipalPreview() {
    Dashboard_V2Theme() {
        Page_Principal()
    }
}
*/
@Composable
fun MainFragment(navController: NavController) {
    val scrollState = rememberLazyListState()
    LazyColumn() {
        item {
            Box {
                val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight

                val maxOffset =
                    with(LocalDensity.current) { imageHeight.roundToPx() }

                val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

                val offsetProgress = max(0f, offset * 3f - 2f)

                TopAppBar(
                    contentPadding = PaddingValues(),
                    backgroundColor = White,
                    modifier = Modifier
                        .height(
                            AppBarExpendedHeight
                        )
                        .offset { IntOffset(x = 0, y = -offset) },
                    elevation = if (offset == maxOffset) 4.dp else 0.dp
                ) {
                    Column {
                        Box(
                            Modifier
                                .height(imageHeight)
                                .graphicsLayer {
                                    alpha = 1f - offsetProgress
                                }) {
                            Image(
                                painter = painterResource(id = R.drawable.principal),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colorStops = arrayOf(
                                                Pair(0.4f, Transparent),
                                                Pair(1f, White)
                                            )
                                        )
                                    )
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    strawberryCake.category,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier
                                        .clip(Shapes.small)
                                        .background(LightGray)
                                        .padding(vertical = 6.dp, horizontal = 16.dp)
                                )
                            }
                        }
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .height(AppBarCollapsedHeight),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                strawberryCake.title,
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(horizontal = (16 + 28).dp)
                                    .scale(1f - 0.25f)
                            )

                        }
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .height(AppBarCollapsedHeight)
                        .padding(horizontal = 16.dp)
                ) {
                    CircularButton()
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                InfoColumn(R.drawable.ic_clock, strawberryCake.cookingTime)
                InfoColumn(R.drawable.ic_flame, strawberryCake.energy)
                InfoColumn(R.drawable.ic_star, strawberryCake.rating)
            }
            Text(
                text = strawberryCake.description,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )
            var value by remember { mutableStateOf(6) }
            /*Row(
    vticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .clip(Shapes.medium)
        .background(LightGray)
        .padding(horizontal = 16.dp)
) {

    Text(text = "Serving", Modifier.weight(1f), fontWeight = FontWeight.Medium)
    CircularButton(
        iconResouce = R.drawable.ic_minus,
        elevation = null,
        color = Pink
    ) { value-- }
    Text(text = "$value", Modifier.padding(16.dp), fontWeight = FontWeight.Medium)
    CircularButton(
        iconResouce = R.drawable.ic_plus,
        elevation = null,
        color = Pink
    ) { value++ }
}*/
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .clip(Shapes.medium)
                    .background(LightGray)
                    .fillMaxWidth()
                    .height(44.dp)
            ) {
                TabButton("Productos", true, Modifier.weight(1f))
                TabButton("Populares", false, Modifier.weight(1f))
                TabButton("Oferta", false, Modifier.weight(1f))
            }
            EasyGrid(nColumns = 3, items = strawberryCake.ingredients) {
                IngredientCard(it.image, it.title, it.subtitle, Modifier)
            }
            Button(
                onClick = { navController.navigate(MenuItem.Page2.ruta) },
                elevation = null,
                shape = Shapes.small,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LightGray,
                    contentColor = Color.Black
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Mas Productos", modifier = Modifier.padding(8.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Reviews", fontWeight = FontWeight.Bold)
                    Text(strawberryCake.reviews, color = DarkGray)
                }
                Button(
                    onClick = { /*TODO*/ }, elevation = null, colors = ButtonDefaults.buttonColors(
                        backgroundColor = Transparent, contentColor = Pink
                    )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("See all")
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null
                        )
                    }
                }
            }
            Row(Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lacteos2),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .clip(Shapes.small)
                )
                Spacer(modifier = Modifier.weight(0.1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_verduras_principal),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .clip(Shapes.small)
                )
            }
        }
        item { Box(modifier = Modifier.height(70.dp)) }

    }
}



@Composable
fun CircularButton(
    color: Color = Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),

) {
    var iconColor by remember { mutableStateOf(Color.Gray) }
    Button(
        onClick = {
            iconColor = if (iconColor == Color.Gray) Color.Green else Color.Gray
        },
        contentPadding = PaddingValues(),
        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = White, contentColor = color),
        elevation = elevation,

        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(Icons.Filled.Favorite, null,tint = iconColor)
    }
}

@Composable
fun <T> EasyGrid(nColumns: Int, items: List<T>, content: @Composable (T) -> Unit) {
    Column(Modifier.padding(16.dp)) {
        for (i in items.indices step nColumns) {
            Row {
                for (j in 0 until nColumns) {
                    if (i + j < items.size) {
                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier.weight(1f)
                        ) {
                            content(items[i + j])
                        }
                    } else {
                        Spacer(Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}


@Composable
fun IngredientCard(
    @DrawableRes iconResource: Int,
    title: String,
    subtitle: String,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        Card(
            shape = Shapes.large,
            elevation = 0.dp,
            backgroundColor = LightGray,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(bottom = 8.dp)
        ) {
            Image(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                modifier = Modifier.padding(16.dp)
            )
        }
        Text(text = title, modifier = Modifier.width(100.dp), fontSize = 14.sp, fontWeight = FontWeight.Medium)
        Text(text = subtitle, color = DarkGray, modifier = Modifier.width(100.dp), fontSize = 14.sp)
    }
}


@Composable
fun TabButton(text: String, active: Boolean, modifier: Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = Shapes.medium,
        modifier = modifier.fillMaxHeight(),
        elevation = null,
        colors = if (active) ButtonDefaults.buttonColors(
            backgroundColor = Pink,
            contentColor = White
        ) else ButtonDefaults.buttonColors(
            backgroundColor = LightGray,
            contentColor = DarkGray
        )
    ) {
        Text(text)
    }
}

@Composable
fun InfoColumn(@DrawableRes iconResouce: Int, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconResouce),
            contentDescription = null,
            tint = Pink,
            modifier = Modifier.height(24.dp)
        )
        Text(text = text, fontWeight = FontWeight.Bold)
    }
}
