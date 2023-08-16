package com.example.cupcakes.ui


import androidx.lifecycle.ViewModel
import com.example.cupcakes.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone


/**
 * Price for a single cupcake
 * Precio por un solo cupcake
 */
private const val PRICE_PER_CUPCAKE =3500.00

/**
 * Additional cost for same day pickup of an order
 * Costo adicianal por el retiro el mismo dia de un pedido
 */
private const val PRICE_FOR_SAME_DAT_PICKUP = 2000.00

/**
 * [OrderViewModel] holds information about a cupcake order in term of quantity, flavor, and
 * pickup date. It also knows how to calculate the total price based on these order details.

 * [OrderViewModel] contiene informacion sobre un predido de cupcakes en cuanto a cantidad, sabor y fecha
 * de recogida. Tambien sabe como calcular el precio total en funcion de estos detalles del pedido.
 */


class OrderViewModel : ViewModel() {
    /**
     * Cupcake state for this order
     * Estado de cupcake para este pedido
     */
    private val _uiState = MutableStateFlow(
        OrderUiState(
            pickupOptions = pickupOptions(),
        )
    )
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    /**
     * Set the quantity [numberCupcakes] of cupcakes for this order's state and udate the price.
     * Establecer la cantidad [numberCupcakes] de cupcakes para el estado de pedido y actualizar el precio
     */
    fun setQuantity(numberCupcakes: Int){
        _uiState.update { currentState ->
            currentState.copy(
                quantity = numberCupcakes,
                price = calculatePrice(quantity = numberCupcakes)
            )
        }
    }
    /**
     * Set the [desiredFlavor] of cupcakes for this order's state.
     * Only 1 flavor can be selected for the whole order.

     * Establecer el [desiredFlavor] de cupcakes para el estado del pedido.
     * Solo se puede seleccionar 1 sabor para todo el pedido.
     */

    fun setFlavor(desiredFlavor: String) {
        _uiState.update { currentState ->
           currentState.copy(flavor = desiredFlavor)
        }
    }
    /**
     *  Set the [pickupDate] for this order's state and update the price
     *  Establecer [pickupDate] para el estado de este pedido y actualice el precio
     */
    fun setDate(pickupDate: String){
       _uiState.update {currentState ->
           currentState.copy(
               date = pickupDate,
               price = calculatePrice(pickupDate = pickupDate)
           )
       }
    }

    /**
     * Reset the order state
     * Restablecer el estado del pedido
     */
    fun resetOrder(){
        _uiState.value = OrderUiState(pickupOptions = pickupOptions())
    }

    /**
     * Returns the calculated price based on the order details.
     */
    private fun calculatePrice(
        quantity: Int = _uiState.value.quantity,
        pickupDate: String = _uiState.value.date
    ) : String{
        var calculatedPrice = quantity * PRICE_PER_CUPCAKE
        // if the user selected the first option (thoday) for pickup, add the surcharge
        // si el usuario selecciono la primera opcion (hoy) para recoger, agregue el recargo
        if (pickupOptions()[0] == pickupDate){
            calculatedPrice += PRICE_FOR_SAME_DAT_PICKUP
        }
        return NumberFormat.getCurrencyInstance().format(calculatedPrice)
    }

    /**
     * Returns a list of date options starting with the current date and the following 3 dates.
     * Devuelve una lista de opciones de fechas que comienza con la fecha actual y las siguientes 3 fechas.
     */

    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()

        Locale.setDefault(Locale("es", "CO"))

        val formatter = SimpleDateFormat("E, d MMMM 'De' HH:mm:ss", Locale.getDefault())

        formatter.timeZone = TimeZone.getTimeZone("America/Bogota")

        val calendar = Calendar.getInstance()
        //add current date and the following 3 dates.
        //agregue la fecha actual y las siguientes 3 fechas
        repeat(4){
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
}