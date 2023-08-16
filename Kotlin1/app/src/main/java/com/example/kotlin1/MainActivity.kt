package com.example.kotlin1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin1.ui.theme.Kotlin1Theme

// La clase MainActivity hereda de ComponentActivity
class MainActivity : ComponentActivity() {
    // Sobrescribe el método onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        // Llama al método onCreate de la superclase
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad
        setContent {
            // Utiliza el tema Kotlin1Theme
            Kotlin1Theme {
                // Muestra una conversación utilizando la función componible Conversation y pasando SampleData.conversationSample como datos de muestra
                Conversation(SampleData.conversationSample)
            }
        }
    }
}

// Clase de datos que representa un mensaje con un autor y un cuerpo
data class Message(val author: String, val body: String)

// Función componible que muestra un mensaje en una fila con una imagen de perfil y el texto del mensaje
@Composable
fun Greeting(msg: Message) {
    // Crea una fila con un relleno de 8.dp en todos los lados
    Row(modifier = Modifier.padding(all = 8.dp)) {
        // Muestra una imagen utilizando painterResource para cargar la imagen de perfil y aplicando varios modificadores para cambiar su tamaño, forma y borde
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        // Agrega un espacio de 8.dp entre la imagen y el texto del mensaje
        Spacer(modifier = Modifier.width(8.dp))
        // Crea una variable mutable isExpanded y la inicializa en false utilizando remember
        var isExpanded by remember { mutableStateOf(false) }
        // Crea una variable surfaceColor y la anima para cambiar su valor según si isExpanded es verdadero o falso
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )
        // Crea una columna que es clickable para cambiar el valor de isExpanded al hacer clic en ella
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            // Muestra el autor del mensaje utilizando un estilo de tipografía subtitle2 y un color secundarioVariant
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2


            )
            // Agrega un espacio de 4.dp entre el autor y el cuerpo del mensaje
            Spacer(modifier = Modifier.height(4.dp))
            // Crea una superficie con una forma medium, una elevación de 1.dp y un color surfaceColor animado. También aplica un modificador animateContentSize para animar el cambio de tamaño al expandir o contraer el texto del mensaje.
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                // Muestra el cuerpo del mensaje utilizando un estilo de tipografía body2 y aplicando un relleno de 4.dp en todos los lados. El número máximo de líneas se establece en Int.MAX_VALUE si isExpanded es verdadero, o en 1 si es falso.
                Text(

                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

// Función componible que muestra una lista de mensajes utilizando un LazyColumn y la función componible Greeting
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            Greeting(message)
        }
    }
}

// Función de vista previa que muestra una vista previa de la conversación en el tema Kotlin1Theme
@Preview
@Composable
fun PreviewConversation() {
    Kotlin1Theme {
        Conversation(SampleData.conversationSample)
    }
}

// Función de vista previa que muestra una vista previa de la conversación en modo claro (Light Mode)
@Preview(name = "Light Mode")

// Función de vista previa que muestra una vista previa de la conversación en modo oscuro (Dark Mode)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

// Función componible que muestra una vista previa del saludo en el tema Kotlin1Theme dentro de una superficie.
@Composable
fun GreetingPreview() {
    Kotlin1Theme {
        Surface {
            Conversation(SampleData.conversationSample)
        }
    }
}
