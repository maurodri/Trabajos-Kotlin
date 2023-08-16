package com.example.appkotlin4

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appkotlin4.ui.theme.AppKotlin4Theme

// La clase MainActivity hereda de ComponentActivity
class MainActivity : ComponentActivity() {
    // Sobrescribe el método onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        // Llama al método onCreate de la superclase
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad
        setContent {
            // Utiliza el tema AppKotlin4Theme
            AppKotlin4Theme {
                // Muestra el contenido de la aplicación utilizando la función componible MyApp y pasando un modificador para llenar el tamaño máximo
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

// Función componible que muestra una pantalla de bienvenida o una lista de saludos, dependiendo del valor de la variable shouldShowOnboarding
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    // Crea una variable mutable shouldShowOnboarding y la inicializa en true utilizando rememberSaveable
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    // Crea una superficie con el modificador pasado como parámetro
    Surface(modifier) {
        // Si shouldShowOnboarding es verdadero, muestra la pantalla de bienvenida utilizando la función componible OnboardingScreen y pasando una función lambda que cambia el valor de shouldShowOnboarding a false como parámetro onContinueClicked
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            // Si shouldShowOnboarding es falso, muestra la lista de saludos utilizando la función componible Greetings
            Greetings()
        }
    }
}

// Función componible que muestra una pantalla de bienvenida con un texto y un botón. Al hacer clic en el botón, se llama a la función onContinueClicked que se pasa como parámetro.
@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit, modifier: Modifier = Modifier) {
    // Crea una columna que llena el tamaño máximo y está centrada horizontal y verticalmente
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Muestra un texto de bienvenida
        Text("Welcome to the Basics Codelab!")
        // Crea un botón con un relleno vertical de 24.dp y llama a la función onContinueClicked al hacer clic en él
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            // Muestra el texto "Continue" en el botón
            Text("Continue")
        }
    }
}

// Función componible que muestra una lista de saludos utilizando un LazyColumn y la función componible Greeting. La lista de nombres se genera utilizando una lista de 1000 elementos con valores desde "0" hasta "999".
@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    // Crea un LazyColumn con un relleno vertical de 4.dp y utiliza la función items para mostrar cada nombre en la lista utilizando la función componible Greeting
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

// Función de vista previa que muestra una vista previa de la pantalla de bienvenida en el tema AppKotlin4Theme. La función onContinueClicked se pasa como una función lambda vacía.
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    AppKotlin4Theme {
        OnboardingScreen(onContinueClicked = {})
    }
}

// Función componible que muestra un saludo en una tarjeta con un color primario y un relleno vertical de 4.dp y horizontal de 8.dp. Utiliza la función componible CardContent para mostrar el contenido de la tarjeta.
@Composable
private fun Greeting(name: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

// Función componible que muestra el contenido de una tarjeta con un nombre. Crea una fila con un relleno de 12.dp y utiliza animateContentSize para animar el cambio de tamaño al expandir o contraer el texto. También crea una columna con un peso de 1f y un relleno de 12.dp para mostrar los textos y un IconButton para expandir o contraer el texto.
@Composable
private fun CardContent(name: String) {
    // Crea una variable mutable expanded y la inicializa en false utilizando rememberSaveable
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    // Crea una fila con un relleno de 12.dp y utiliza animateContentSize para animar el cambio de tamaño al expandir o contraer el texto
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        // Crea una columna con un peso de 1f y un relleno de 12.dp para mostrar los textos
        Column(modifier = Modifier.weight(1f)
            .padding(12.dp)
        ) {
            // Muestra el texto "Hello"
            Text(
                text = "Hello",
            )
            // Muestra el nombre utilizando un estilo de tipografía headlineMedium y un peso de fuente ExtraBold
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            // Si expanded es verdadero, muestra un texto adicional repetido 4 veces
            if (expanded) {
                Text(
                    text = ("composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        // Crea un IconButton que cambia el valor de expanded al hacer clic en él y muestra un icono diferente dependiendo del valor de expanded
        IconButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

// Función de vista previa que muestra una vista previa de la lista de saludos en modo oscuro (Dark) en el tema AppKotlin4Theme
@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
// Función de vista previa que muestra una vista previa de la lista de saludos en modo claro (Light) en el tema AppKotlin4Theme
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    AppKotlin4Theme {
        Greetings()
    }
}

// Función de vista previa que muestra una vista previa del contenido de la aplicación en el tema AppKotlin4Theme utilizando la función componible MyApp y pasando un modificador para llenar el tamaño máximo
@Preview
@Composable
fun MyAppPreview() {
    AppKotlin4Theme {
        MyApp(Modifier.fillMaxSize())
    }
}




