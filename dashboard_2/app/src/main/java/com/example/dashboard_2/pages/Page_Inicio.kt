package com.example.dashboard_2.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dashboard_2.R


@Composable
fun Page_Inicio() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(4.dp)
                .clickable { },
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.nt_granejro),
                    contentDescription = "noticia1"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Automatizacion en campo",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Aprendices del semillero de investigación SISPROPEC del SENA Mosquera adelantan un proyecto de automatización de trabajos de campo" +
                                " y uso de herramientas digitales para el sector ganadero en el trópico alto",
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
                    painter = painterResource(id = R.drawable.nt_teleperformance),
                    contentDescription = "noticia2"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "SENA y Teleperformance abren 400 oportunidades",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Los interesados podrán acceder a ofertas laborales en modalidad de teletrabajo.",
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
        Card(modifier = Modifier
            .padding(4.dp, top = 8.dp)
            .clickable { }
            .fillMaxWidth(),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.nt_porcinos),
                    contentDescription = "noticia3"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Tecnología de punta para la producción porcina en Pasto",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Una nueva era en la cría de cerdos. El Centro Lope del SENA, en la capital nariñense, se renueva con una inversión millonaria para impulsar la producción limpia y eficiente",
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
        Card(modifier = Modifier
            .padding(4.dp, top = 8.dp, bottom = 120.dp)
            .clickable { }
            .fillMaxWidth(),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.nt_agrosena),
                    contentDescription = "noticia4"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Magdalena, epicentro de la primera Feria Tecnológica AgroSENA",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Pequeños productores agropecuario de la subregión Río del departamento asistieron al evento liderado por el Centro Acuícola y Agroindustrial de Gaira del SENA Regional Magdalena",
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