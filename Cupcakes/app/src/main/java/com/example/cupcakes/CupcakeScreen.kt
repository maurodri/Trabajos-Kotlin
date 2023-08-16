package com.example.cupcakes

import android.content.Context
import android.content.Intent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cupcakes.data.DataSource
import com.example.cupcakes.ui.OrderSummaryScreen
import com.example.cupcakes.ui.OrderViewModel
import com.example.cupcakes.ui.SelectOptionScreen
import com.example.cupcakes.ui.StartOrderScreen


/**
 * enum values that represent the screens in the app
 * valores de enumeracion que representan las pantallas en la app
 */

//@StrinRes proporciona informacion adicional al compilador lo que permite saber un parametro 'Int'
// representa un valor de cadena y no uno entero arbitrario
enum class CupcakeScreen(@StringRes val title: Int){
    Start(title = R.string.app_name ),
    Flavor(title = R.string.choose_flavor),
    Pickup(title = R.string.choose_pickup_date),
    Summary(title = R.string.order_summary)
}

/**
 Composable that displays the topBar and displays back button if back navigation is possible.
 componente que muestra la barra superior y muestra el boton de atras si es posible navegar hacia atrás.
*/

/*
@OptIn(ExperimentalMaterial3Api::class) se usa para indicar que se esta usando una API experimental
de la biblioteca de Material Design de Google version 3 y se usa @OptIn para referirse que podria
cambiar versiones en el futuro
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(
    currentScreen: CupcakeScreen,
    canNavigateBack: Boolean,
    /*la notacion ()-> Unit se usa especificar que navigateUp es una funcion que no tiene argumentos de entrada
     y no devuelve ningun valor eso significa que al ejecutarse solo hara la accion sin devolver algun resultado
    */
    navigateUp: ()-> Unit,
    modifier:Modifier = Modifier
) {
    TopAppBar(
        title = {Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // get current back stack entry (obtener la entrada actual)
    val backStackEntry by navController.currentBackStackEntryAsState()

    /* get the name of the current screen
     (backStackEntry?.destination?.route ?: CupcakeScreen.Start.name) devuelve la ruta de la pantalla actual
     en la pila de navegacion. Si no hay ninguna pantalla en la pila de navegacion se usa el nombre de la pantalla
     de inicio
    */
    val currentScreen = CupcakeScreen.valueOf(
        backStackEntry?.destination?.route ?: CupcakeScreen.Start.name
    )
    Scaffold (
        topBar = {
            CupcakeAppBar(
                //nombre de la pantalla
                currentScreen = currentScreen,
                /* verifica y obtiene la pila de navegacion con navController.previousBackStackEntry
                y si hay una pantalla anterior establecera un true lo que hara que se muestre el boton
                de lo contrario sera un false y no mostrata el boton
                */
                canNavigateBack = navController.previousBackStackEntry != null,
                // la funcion del boton
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { //establece un relleno interno en la interfaz de usuario y usa viewModel y collectAsState()
        // para almacenar y actualizarel estado de la interfaz de usuario, uiState almacena el estado
        // de la interfaz
            innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CupcakeScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = CupcakeScreen.Start.name){
                StartOrderScreen(
                    quantityOptions = DataSource.quantityOptions,
                    onNextButtonClicked = {
                        viewModel.setQuantity(it)
                        navController.navigate(CupcakeScreen.Flavor.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = CupcakeScreen.Flavor.name) {
                val context = LocalContext.current
                SelectOptionScreen(
                    subtotal = uiState.price,
                    onNextButtonClicked = {
                        navController.navigate(CupcakeScreen.Pickup.name)
                    },
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    options = DataSource.flavors.map {id -> context.resources.getString(id)},
                    onSelectionChanged = {viewModel.setFlavor(it)},
                    modifier = Modifier.fillMaxHeight()
                )

            }
            composable(route = CupcakeScreen.Pickup.name) {
                SelectOptionScreen(
                    subtotal = uiState.price,
                    onNextButtonClicked = {
                        navController.navigate(CupcakeScreen.Summary.name)
                    },
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    options = uiState.pickupOptions,
                    onSelectionChanged = {viewModel.setDate(it)},
                    modifier = Modifier.fillMaxHeight()
                )

            }
            composable(route = CupcakeScreen.Summary.name) {
                val context = LocalContext.current
                OrderSummaryScreen(
                    orderUiState = uiState,

                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    onSendButtonClicked = {subject: String, summary: String ->
                        shareOrder(context, subject = subject, summary = summary)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }
}
/**
 * Resets the [orderUiState] and pops up to [CupcakeScreen.Start]
 * Restablece el [orderUiState] y aparece en [CupcakeScreen.Start]
 */

private fun cancelOrderAndNavigateToStart(
    viewModel: OrderViewModel,
    navController: NavHostController
){
    viewModel.resetOrder()
    navController.popBackStack(CupcakeScreen.Start.name, inclusive = false)
}

/**
 * Creates on intent to share order details
 * Crea con la intencion de compartir los detalles del pedido
 */
private fun shareOrder(context: Context, subject: String, summary: String){
    //create an ACTION_SEND implicit intent with order details in the intent extras
    //crea una intencion implicita ACTION_SEND con detalles del pedido en extras de la intención
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.new_cupcake_order)
        )
    )
}