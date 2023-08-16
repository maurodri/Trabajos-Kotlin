package com.example.cupcakes.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcakes.R
import com.example.cupcakes.ui.components.FormattedPriceLabel


/**
 * Composable that displays the list of items as [RadioButton] options,
 * [onSelectionChanged] lambda that notifies the parent composable when a new value is selected,
 * [onCancelButtonClicked] lambda that cancels the order when user clicks cancel and
 * [onNextButtonClicked] lambda that triggers the navigation to next screen

 * Componible que muestra la lista de elementos como opciones [RadioButton],
 * [onSelectionChanged] lambda que notifica al componente principal cuando se selecciona un nuevo valor,
 * [onCancelButtonClicked] lambda que cancela el pedido cuando el usuario hace click en cancelar y
 * [onNextButtonClicked] lambda que activa la navegacion a la siguiente pantalla
 */
@Composable
fun SelectOptionScreen(
    modifier: Modifier = Modifier,
    subtotal: String,
    options: List<String>,
    onSelectionChanged: (String) ->Unit = {},
    onCancelButtonClicked: ()-> Unit = {},
    onNextButtonClicked: ()-> Unit = {}
) {
    var selectedValue by rememberSaveable{ mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    )  {
        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            options.forEach{ item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                )  {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
            Divider(
                thickness = dimensionResource(id = R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
            )
            FormattedPriceLabel(
                subtotal = subtotal,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_medium),
                        bottom = dimensionResource(id = R.dimen.padding_medium)
                    )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        )  {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(id = R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                //el boton se habilita cuando el usuario hace una seleccion
                enabled = selectedValue.isNotEmpty(),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(id = R.string.next))
            }
        }
    }
}

@Preview
@Composable
fun SelectOptionPreview() {
    SelectOptionScreen(
        subtotal = "299.99",
        options = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
        modifier = Modifier.fillMaxHeight()
    )
}
