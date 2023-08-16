package com.example.dashboard_2.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColumnCards(
    @DrawableRes imgbody: Int,
    @StringRes textbody: Int,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray)
    ) {
        Column() {
            //Header

            //Cuerpo
            Image(
                painter = painterResource(imgbody),
                contentDescription = "Imagenes",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(RectangleShape)
            )
            Row(Modifier.padding(start = 16.dp, end = 20.dp, top = 16.dp)) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = stringResource(textbody),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            //Pie
            CompositionLocalProvider(
                LocalContentAlpha provides ContentAlpha.medium,
                LocalMinimumTouchTargetEnforcement provides false
            ) {

                Row() {

                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(
                                15.dp
                            )
                    ) {
                        Row() {
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Comprar")
                            }

                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Detalle")
                            }
                        }
                    }
//                    Column(modifier = Modifier.absolutePadding(right = 2.dp, bottom = 1.dp)) {
//                        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(30.dp)) {
//                            Icon(Icons.Default.Favorite, contentDescription = null)
//                        }
//                        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(30.dp)) {
//                            Icon(Icons.Default.Share, contentDescription = null)
//                        }
//                    }

                }


            }
        }
    }
}


@Composable
fun Filas(collection: List<DrawableStringQuintuple>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(
            collection
        ) { item ->
            ColumnCards(
                item.imgbody,
                item.textbody,
            )
        }
    }
}

//private val DatosFilas = listOf(
//    Quintuple(
//        R.drawable.ic_flores,
//        R.string.canal_tienda,
//        R.string.canal_tienda,
//        R.drawable.ic_frutas,
//        R.string.canal_tienda
//    ),
//    Quintuple(
//        R.drawable.ic_flores,
//        R.string.canal_tienda,
//        R.string.canal_tienda,
//        R.drawable.ic_lacteos,
//        R.string.canal_tienda
//    ),
//    Quintuple(
//        R.drawable.ic_flores,
//        R.string.canal_tienda,
//        R.string.canal_tienda,
//        R.drawable.ic_granos,
//        R.string.canal_tienda
//    ),
//    Quintuple(
//        R.drawable.ic_flores,
//        R.string.canal_tienda,
//        R.string.canal_tienda,
//        R.drawable.ic_proteinas,
//        R.string.canal_tienda
//    ),
//
//    ).map { DrawableStringQuintuple( it.title, it.subtitle, it.imgbody, it.textbody) }


data class Quintuple(

    @DrawableRes val imgbody: Int,
    @StringRes val textbody: Int

)

data class DrawableStringQuintuple(
    val imgbody: Int,
    val textbody: Int
)


/*@Preview(showBackground = true)
@Composable
fun CardPreview() {
    MaterialTheme {
        Cardsita(img = R.drawable.ic_flores, text = R.string.CanalTienda)
    }
}*/

//@Preview(showBackground = true)
//@Composable
//fun FilasPreview() {
//    MaterialTheme {
//        Filas(collection = DatosFilas)
//    }
//}