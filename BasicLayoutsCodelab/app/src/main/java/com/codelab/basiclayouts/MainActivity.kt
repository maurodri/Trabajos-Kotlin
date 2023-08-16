
package com.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basiclayouts.ui.theme.MySootheTheme
import java.util.*

// Esta es una clase llamada MainActivity que hereda de la clase ComponentActivity
class MainActivity : ComponentActivity() {
    // Esta función se llama cuando se crea la actividad por primera vez
    override fun onCreate(savedInstanceState: Bundle?) {
        // Llame a la implementación de onCreate de la superclase
        super.onCreate(savedInstanceState)
        // Establezca el contenido de la actividad para que sea la función compuesta MySootheApp
        setContent { MySootheApp() }
    }
}


// Paso: Barra de búsqueda - Modificadores
@Composable
fun SearchBar(
    modifier: Modifier = Modifier // El modificador se pasa como un parámetro opcional
) {
    // Implementa el composable aquí
    TextField(
        value = "", // El valor inicial del campo de texto es una cadena vacía
        onValueChange = {}, // La función de devolución de llamada para manejar cambios en el valor del campo de texto
        leadingIcon = { // Icono a la izquierda del campo de texto
            Icon(
                imageVector = Icons.Default.Search, // Usa el icono de búsqueda predeterminado
                contentDescription = null // La descripción del contenido para la accesibilidad es nula
            )
        },
        colors = TextFieldDefaults.textFieldColors( // Colores personalizados para el campo de texto
            backgroundColor = MaterialTheme.colors.surface // Usa el color de la superficie del tema actual como color de fondo
        ),
        placeholder = { // Texto del marcador de posición para el campo de texto
            Text(stringResource(R.string.placeholder_search)) // Usa el recurso de cadena para el marcador de posición
        },
        modifier = modifier // Aplica el modificador pasado como parámetro al campo de texto
            .fillMaxWidth() // El campo de texto debe llenar el ancho máximo disponible
            .heightIn(min = 56.dp) // La altura mínima del campo de texto es 56.dp
    )
}

// Paso: Alinea tu cuerpo - Alineación
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int, // Recurso dibujable para la imagen
    @StringRes text: Int, // Recurso de cadena para el texto
    modifier: Modifier = Modifier // El modificador se pasa como un parámetro opcional
) {
    // Implementa el composable aquí
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) { // Columna con elementos centrados horizontalmente y modificador aplicado
        Image(
            painter = painterResource(drawable), // Usa el recurso dibujable pasado como parámetro para la imagen
            contentDescription = null, // La descripción del contenido para la accesibilidad es nula
            contentScale = ContentScale.Crop, // La imagen se recorta para llenar el espacio disponible
            modifier = Modifier // Aplica un modificador a la imagen
                .size(88.dp) // El tamaño de la imagen es 88.dp por 88.dp
                .clip(CircleShape) // Recorta la imagen en forma de círculo
        )
        Text(
            text = stringResource(text), // Usa el recurso de cadena pasado como parámetro para el texto
            style = MaterialTheme.typography.h3, // Usa el estilo tipográfico h3 del tema actual para el texto
            modifier = Modifier.paddingFromBaseline( // Aplica un relleno desde la línea base al texto
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

// Paso: Tarjeta de colección favorita - Superficie Material
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int, // Recurso dibujable para la imagen
    @StringRes text: Int, // Recurso de cadena para el texto
    modifier: Modifier = Modifier // El modificador se pasa como un parámetro opcional
) {
    // Implementa el composable aquí
    Surface(
        shape = MaterialTheme.shapes.small, // Usa la forma pequeña del tema actual para la superficie
        modifier = modifier // Aplica el modificador pasado como parámetro a la superficie
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente los elementos en el centro
            modifier = Modifier.width(192.dp)  // El ancho de la fila es 192.dp
        ) {
            Image(
                painter = painterResource(drawable),  // Usa el recurso dibujable pasado como parámetro para la imagen
                contentDescription = null,  // La descripción del contenido para la accesibilidad es nula
                contentScale = ContentScale.Crop,  // La imagen se recorta para llenar el espacio disponible
                modifier = Modifier.size(56.dp)  // El tamaño de la imagen es 56.dp por 56.dp
            )
            Text(
                text = stringResource(text),  // Usa el recurso de cadena pasado como parámetro para el texto
                style = MaterialTheme.typography.h3,  // Usa el estilo tipográfico h3 del tema actual para el texto
                modifier = Modifier.padding(horizontal = 16.dp)  // Aplica un relleno horizontal de 16.dp al texto
            )
        }
    }
}

// Paso: Fila de alineación de tu cuerpo - Arreglos
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier // El modificador se pasa como un parámetro opcional
) {
    // Implementa el composable aquí
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Los elementos se espacian horizontalmente por 8.dp
        contentPadding = PaddingValues(horizontal = 16.dp), // El relleno de contenido horizontal es 16.dp
        modifier = modifier // Aplica el modificador pasado como parámetro a la fila perezosa
    ){
        items(alignYourBodyData){item -> // Itera sobre los datos de alignYourBodyData y muestra cada elemento
            AlignYourBodyElement(item.drawable , item.text) // Muestra el elemento usando la función AlignYourBodyElement
        }
    }
}

// Paso: Cuadrícula de colecciones favoritas - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier // El modificador se pasa como un parámetro opcional
) {
    // Implementa el composable aquí
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2), // La cuadrícula tiene 2 filas fijas
        contentPadding = PaddingValues(horizontal = 16.dp), // El relleno de contenido horizontal es 16.dp
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Los elementos se espacian horizontalmente por 8.dp
        verticalArrangement = Arrangement.spacedBy(8.dp), // Los elementos se espacian verticalmente por 8.dp
        modifier = modifier.height(120.dp) // Aplica el modificador pasado como parámetro y establece la altura en 120.dp
    ){
        items(favoriteCollectionsData){item -> // Itera sobre los datos de favoriteCollectionsData y muestra cada elemento
            FavoriteCollectionCard(
                drawable = item.drawable, // Usa el recurso dibujable del elemento para la tarjeta
                text = item.text, // Usa el recurso de cadena del elemento para la tarjeta
                modifier = Modifier.height(56.dp)) // Establece la altura de la tarjeta en 56.dp
        }
    }
}

// Paso: Sección de inicio - APIs de ranura
@Composable
fun HomeSection(
    @StringRes title: Int, // Recurso de cadena para el título de la sección
    modifier: Modifier = Modifier, // El modificador se pasa como un parámetro opcional
    content: @Composable () -> Unit // Contenido componible para mostrar en la sección, pasado como una función lambda
) {
    // Implementa el composable aquí
    Column(modifier) { // Columna con modificador aplicado
        Text(stringResource(title).uppercase(Locale.getDefault()), // Muestra el título en mayúsculas usando el recurso de cadena pasado como parámetro y el idioma predeterminado del dispositivo
            style = MaterialTheme.typography.h2, // Usa el estilo tipográfico h2 del tema actual para el título
            modifier = Modifier // Aplica un modificador al título
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp) // Aplica un relleno desde la línea base al título
                .padding(horizontal = 16.dp) // Aplica un relleno horizontal de 16.dp al título
        )
        content() // Muestra el contenido componible pasado como parámetro en la columna
    }
}

// Paso: Pantalla de inicio - Desplazamiento
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Implementa el composable aquí
    Column(
        modifier
            .verticalScroll(rememberScrollState()) // Habilita el desplazamiento vertical en la columna
            .padding(vertical = 16.dp)) // Aplica un relleno vertical de 16.dp a la columna
    {
        Spacer(Modifier.height(16.dp)) // Agrega un espacio de 16.dp de altura
        SearchBar(Modifier.padding(horizontal = 16.dp)) // Muestra la barra de búsqueda con un relleno horizontal de 16.dp
        HomeSection(title = R.string.align_your_body) { // Muestra la sección "Alinea tu cuerpo"
            AlignYourBodyRow() // Muestra la fila de elementos "Alinea tu cuerpo"
        }
        HomeSection(title = R.string.favorite_collections) { // Muestra la sección "Colecciones favoritas"
            FavoriteCollectionsGrid() // Muestra la cuadrícula de colecciones favoritas
        }
        Spacer(Modifier.height(16.dp)) // Agrega un espacio de 16.dp de altura
    }
}

// Paso: Navegación inferior - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    // Implementa el composable aquí
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background, // Usa el color de fondo del tema actual para el fondo de la navegación inferior
        modifier = modifier) { // Aplica el modificador pasado como parámetro a la navegación inferior
        BottomNavigationItem(
            icon = { // Icono para el elemento de navegación inferior "Inicio"
                Icon(
                    imageVector = Icons.Default.Spa, // Usa el icono predeterminado "Spa"
                    contentDescription = null // La descripción del contenido para la accesibilidad es nula
                )
            },
            label = { // Etiqueta para el elemento de navegación inferior "Inicio"
                Text(stringResource(R.string.bottom_navigation_home)) // Usa el recurso de cadena para la etiqueta
            },
            selected = true, // Este elemento está seleccionado actualmente
            onClick ={} // Función de devolución de llamada para manejar clics en este elemento
        )
        BottomNavigationItem(
            icon = { // Icono para el elemento de navegación inferior "Perfil"
                Icon(
                    imageVector = Icons.Default.AccountCircle, // Usa el icono predeterminado "AccountCircle"
                    contentDescription = null // La descripción del contenido para la accesibilidad es nula
                )
            },
            label = { // Etiqueta para el elemento de navegación inferior "Perfil"
                Text(stringResource(R.string.bottom_navigation_profile)) // Usa el recurso de cadena para la etiqueta
            },
            selected = false, // Este elemento no está seleccionado actualmente
            onClick ={} // Función de devolución de llamada para manejar clics en este elemento
        )
    }
}

// Paso: Aplicación MySoothe - Andamio (Scaffold)
@Composable
fun MySootheApp() {
    // Implementa el composable aquí
    MySootheTheme { // Usa el tema personalizado MySootheTheme para la aplicación
        Scaffold(
            bottomBar = {
                SootheBottomNavigation() // Muestra la navegación inferior usando la función SootheBottomNavigation
            }
        ) {
                padding ->
            HomeScreen(Modifier.padding(padding)) // Muestra la pantalla de inicio con el relleno proporcionado por Scaffold
        }
    }
}

// Datos para los elementos "Alinea tu cuerpo"
private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

// Datos para las colecciones favoritas
private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

// Clase de datos para almacenar un par de recursos dibujables y de cadena
private data class DrawableStringPair(
    @DrawableRes val drawable: Int, // Recurso dibujable
    @StringRes val text: Int // Recurso de cadena
)

// Vista previa para la barra de búsqueda
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    MySootheTheme { SearchBar(Modifier.padding(8.dp)) } // Muestra la barra de búsqueda con un relleno de 8.dp en el tema MySootheTheme
}

// Vista previa para el elemento "Alinea tu cuerpo"
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyElementPreview() {
    MySootheTheme {
        AlignYourBodyElement(
            text = R.string.ab1_inversions, // Usa el recurso de cadena para el texto del elemento
            drawable = R.drawable.ab1_inversions, // Usa el recurso dibujable para la imagen del elemento
            modifier = Modifier.padding(8.dp) // Aplica un relleno de 8.dp al elemento
        )
    }
}

// Vista previa para la tarjeta de colección favorita
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    MySootheTheme {
        FavoriteCollectionCard(
            text = R.string.fc2_nature_meditations, // Usa el recurso de cadena para el texto de la tarjeta
            drawable = R.drawable.fc2_nature_meditations, // Usa el recurso dibujable para la imagen de la tarjeta
            modifier = Modifier.padding(8.dp) // Aplica un relleno de 8.dp a la tarjeta
        )
    }
}
