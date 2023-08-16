package com.example.dashboard_v2.pages.Login

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.dashboard_v2.R
import com.example.dashboard_v2.components.CreateChannelNotification
import com.example.dashboard_v2.components.MenuItem
import com.example.dashboard_v2.components.notificacionImagen
import com.example.dashboard_v2.components.notificacionSencilla

@Composable
fun LoginScreen(navController: NavHostController) {
    val showLoginForm = rememberSaveable {
        mutableStateOf(true)
    }
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 5000,
                easing = LinearEasing
            )
        )
    )
    // Detecta cualquier Gif
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .background(Color(0xFF8BC34A))
        ) {
            //Valores para la posicion de la Box
            val boxWidth = maxWidth
            val boxHeight = maxHeight

            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = R.drawable.present)
                        .apply(block = fun ImageRequest.Builder.() {
                            size(Size.ORIGINAL)
                        }).build(),
                    imageLoader = imageLoader
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .offset(
                        //Horizontal
                        x = (boxWidth - 400.dp) / 2,
                        //Vertical
                        y = (boxHeight - 380.dp) / 2
                    )
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Box(
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.Black)
                        .background(Color.White.copy(alpha = 0.5f))
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.sena),
                            contentDescription = "Logo Sena",
                            modifier = Modifier
                                .size(200.dp)
                                .padding(8.dp),
                            contentScale = ContentScale.Crop
                        )
                        if (showLoginForm.value) {

                            UserForm(
                                isCreateAccount = false,
                                { email, password ->
                                    Log.d("TiendaApp", "Inicio sesion con $email y $password")
                                },
                                navController = navController
                            )
                        } else {

                            UserForm(
                                isCreateAccount = true,
                                { email, password ->
                                    Log.d("TiendaApp", "Creando Cuenta con $email y $password")
                                },
                                navController = navController
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .height(15.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val text1 =
                                if (showLoginForm.value)
                                    "¿No Tienes Cuenta?"
                                else
                                    "¿Ya Tienes Cuenta?"
                            val text2 =
                                if (showLoginForm.value)
                                    "Registrate"
                                else
                                    "Inicia Sesión"
                            androidx.compose.material.Text(
                                text = text1,
                                modifier = Modifier,
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            androidx.compose.material.Text(
                                text = text2,
                                modifier = Modifier
                                    .clickable { showLoginForm.value = !showLoginForm.value }
                                    .padding(start = 5.dp),
                                color = Color.Green,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = { email, pwd -> },
    navController: NavHostController
) {
    val email = rememberSaveable {
        mutableStateOf("")
    }
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable() {
        mutableStateOf(false)
    }
    val validState = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailInput(emailState = email)
        PasswordInput(
            passwordState = password,
            labelid = "Password",
            passwordVisible = passwordVisible
        )
        SubmitButton(
            textId =
            if (isCreateAccount)
                "Crear Cuenta"
            else
                "Iniciar Sesión",
            inputValid = validState,
            isCreateAccount = isCreateAccount,
            onClick = {
                onDone(email.value.trim(), password.value.trim())
                keyboardController?.hide()
            },
            navController = navController
        )
    }
}

@Composable
fun SubmitButton(
    textId: String,
    inputValid: Boolean,
    isCreateAccount: Boolean,
    onClick: () -> Unit,
    navController: NavHostController
) {
    //Valores de notificaciones
    val idNotification = 0
    val context: Context = LocalContext.current
    val idChannel: String = stringResource(R.string.canal_tienda)
    val name = stringResource(R.string.canal_tienda)
    val descriptionText = stringResource(R.string.canal_notificaciones)

    val textShort = "Su Inicio de Sesion se a realizado con exito."
    val textLong: String = "Saludos! Usted se a Registrado Exitosamente " +
            "El CBA le agradece que nos acompañe en cada momento "

    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.bg_sena
    )
    //Funcion de creacion propia como corrutina
    LaunchedEffect(Unit) {
        CreateChannelNotification(
            idChannel,
            context,
            name,
            descriptionText
        )
    }
    androidx.compose.material.Button(
        onClick = {
            onClick()
            if (isCreateAccount) {
                // Enviar notificación de bienvenida al registrarse
                notificacionImagen(
                    context,
                    idChannel,
                    idNotification + 2,
                    "Notificacion De Registro",
                    textLong,
                    imagenBig
                )
            } else {
                // Enviar notificación de inicio de sesión exitoso
                notificacionSencilla(
                    context,
                    idChannel,
                    idNotification,
                    "Tienda CBA",
                    textShort
                )
            }
            navController.navigate(MenuItem.Page1.ruta)
        },
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValid
    ) {
        androidx.compose.material.Text(
            text = textId,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}


@Composable
fun EmailInput(emailState: MutableState<String>, labelId: String = "Email") {
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyboarType = KeyboardType.Email
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelid: String,
    passwordVisible: MutableState<Boolean>
) {
    val visualTransformation = if (passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()
    OutlinedTextField(
        value = passwordState.value, onValueChange = { passwordState.value = it },
        label = { Text(text = labelid) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (passwordState.value.isNotBlank()) {
                PasswordVisibleIcon(passwordVisible)
            } else null
        }
    )
}

@Composable
fun PasswordVisibleIcon(passwordVisible: MutableState<Boolean>) {
    val image = if (passwordVisible.value)
        Icons.Default.VisibilityOff
    else
        Icons.Default.Visibility
    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
        Icon(imageVector = image, contentDescription = "")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean = true,
    keyboarType: KeyboardType
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboarType),
    )
}
