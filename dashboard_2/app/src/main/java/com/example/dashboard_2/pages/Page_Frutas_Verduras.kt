package com.example.dashboard_2.pages


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dashboard_2.R
import com.example.dashboard_2.components.DrawableStringQuintuple
import com.example.dashboard_2.components.Filas
import com.example.dashboard_2.components.Quintuple

@Composable
fun Page_Frutas_Verduras() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = DatosFlores)
    }
}

private val DatosFlores = listOf(
    Quintuple(
        R.drawable.ic_frutas_2,
        R.string.textoPrueba
    ),
    Quintuple(
        R.drawable.ic_frutas_3,
        R.string.textoPrueba
    ),
    Quintuple(

        R.drawable.ic_verdura_2,
        R.string.textoPrueba
    ),
    Quintuple(

        R.drawable.ic_verduras_3,
        R.string.textoPrueba
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody) }


@Preview(showBackground = true)
@Composable
fun Page_Frutas_VerdurasPreview() {
    Page_Frutas_Verduras()
}