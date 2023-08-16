package com.example.cupcakes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cupcakes.R


/**
 *  Composable that displays formatted [price] that will be formatted and displayed on screen
 *  Componible que muestra el [precio] formateado que se formateara y mostrara en la pantalla
 */

@Composable
fun FormattedPriceLabel(subtotal: String, modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = stringResource(id = R.string.subtotal_price , subtotal),
            modifier = modifier,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
