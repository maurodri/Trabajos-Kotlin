package com.example.dashboard_2.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dashboard_2.R
import com.example.dashboard_2.ui.theme.Dashboard_2Theme

@Composable
fun Page_Flores() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Card(modifier = Modifier
            .padding(4.dp)
            .clickable { },
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.bg_sena),
                    contentDescription = "senaflores"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Flores del sena xd",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Una flor típica consta de cuatro verticilos, cáliz, corola, androceo (estambres) y gineceo (pistilo). " +
                                "éstos se insertan en el receptáculo, que se encuentra en el extremo del pedicelo que une la flor a la rama.",
                        style = MaterialTheme.typography.h6,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box() {
                            Row() {
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Ver mas")
                                }
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Comprar")
                                }
                            }
                        }
                        Box() {
                            Row() {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Favorito"
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
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
//        Segunda Card
        Card(modifier = Modifier
            .padding(4.dp, top = 8.dp)
            .clickable { }
            .fillMaxWidth(),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.ic_frutas),
                    contentDescription = "senaflores"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Frutas del sena xd",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Producto alimenticio comestible que se obtiene de plantas o árboles y que se caracteriza por ser generalmente de sabor dulce",
                        style = MaterialTheme.typography.h6,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box() {
                            Row() {
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Ver mas")
                                }
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Comprar")
                                }
                            }
                        }
                        Box() {
                            Row() {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Favorito"
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
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
fun Page_FloresPreview() {
    Dashboard_2Theme {
        Page_Flores()
    }
}