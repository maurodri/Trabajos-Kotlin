package com.example.dashboard_v2.pages

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
import com.example.dashboard_v2.R
import com.example.dashboard_v2.components.DrawableStringQuintuple
import com.example.dashboard_v2.components.Filas
import com.example.dashboard_v2.components.Quintuple
import com.example.dashboard_v2.ui.theme.Dashboard_V2Theme

@Composable
fun Page_Flores() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = DatosFlores)
    }
}

private val DatosFlores = listOf(

    Quintuple(
        R.drawable.fl_flor_1,
        R.string.Dahlia_title,
        R.string.Dahlia_Detalles
    ),
    Quintuple(
        R.drawable.fl_flor_2,
        R.string.Flor_rosa_title,
        R.string.Flor_rosa_detalles,
    ),
    Quintuple(
        R.drawable.fl_flor_3,
        R.string.Dahlia_title2,
        R.string.Dahlia_Detalles,
    ),
    Quintuple(
        R.drawable.fl_flor_4,
        R.string.Dahlia_title3,
        R.string.Dahlia_Detalles,
    ),
    Quintuple(
        R.drawable.fl_flor_5,
        R.string.Geranio,
        R.string.Geranio_detalles
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody, it.detallebody) }

@Preview(showBackground = true)
@Composable
fun Page_FloresPreview() {
    Dashboard_V2Theme {
        Page_Flores()
    }
}