package com.example.cupcakes.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.cupcakes.R
import com.example.cupcakes.data.OrderUiState
import com.example.cupcakes.ui.components.FormattedPriceLabel

/**
 * This composable expects [orderUiState] that represents the order state, [onCancelButtonClicked]
 * lambda that triggers canceling the order and passes the final order to [onSendButtonClicked]
 * lambda

 * Este componible espera [orderUiState] que representa el estado del predido, [onCancelButtonClicked]
 * lambda que activa la cancelacion del pedido y pasa el pedido a [onSendButtonClicked]
 * lambda
 */

@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: ()-> Unit,
    onSendButtonClicked: (String, String) ->Unit,
    modifier: Modifier = Modifier
) {
    val resources = LocalContext.current.resources

    val numberOfCupcakes = resources.getQuantityString(
        R.plurals.cupcakes,
        orderUiState.quantity,
        orderUiState.quantity
    )
    //Load and format a string resource with the parameters.
    //cargar y formatear un recurso de cadena con los parametros
    val orderSummary = stringResource(
        R.string.order_details,
        numberOfCupcakes,
        orderUiState.flavor,
        orderUiState.date,
        orderUiState.quantity
    )
    val newOrder = stringResource(id = R.string.new_cupcake_order)
    //create a list of order summary to display
    //crear una lista de resumen de pedido para mostrar
    val items = listOf(
        //summary line 1: display selected quantity
        // linea de resumen 1: muestra cantidad seleccionada
        Pair(stringResource(R.string.quantity), numberOfCupcakes),
        //summary line 2: display selected flavor
        // linea de resumen 2: muestra el sabor seleccionado
        Pair(stringResource(R.string.flavor), orderUiState.flavor),
        //summary line 3: display selected pickup date
        // linea de resumen 3: muestra la fecha de recogida seleccionada
        Pair(stringResource(R.string.pickup_date), orderUiState.date),
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        )  {
            items.forEach{item ->
                Text(item.first.uppercase())
                Text(text = item.second, fontWeight = FontWeight.Bold)
                Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            FormattedPriceLabel(
                subtotal = orderUiState.price,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .weight(1f, false),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))

            )  {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onSendButtonClicked(newOrder, orderSummary)}
                ) {
                    Text(stringResource(id = R.string.send))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(id = R.string.cancel))
                }
            }
        }
    }

}