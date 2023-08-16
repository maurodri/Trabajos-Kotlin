package com.example.dashboard_v2.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dashboard_v2.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.maps.android.compose.widgets.DisappearingScaleBar
import com.google.maps.android.compose.widgets.ScaleBar

val SenaCBA = LatLng(4.695753093748901, -74.21563995530865)
val bloqueB = LatLng(4.695538385068109, -74.21656427115464)
val bloqueC = LatLng(4.69515292089118, -74.21690531784317)
val Conejera = LatLng(4.694055086751428, -74.21867206475034)
val Galpon = LatLng(4.693635291894101, -74.21897501183481)

@Composable
fun Page_Ubicacion() {
    Column {
        MapasScreen()
    }
}

@Composable
fun MapasScreen() {
    val defaultCameraPosition = CameraPosition.fromLatLngZoom(SenaCBA, 11f)
    val cameraPositionState = rememberCameraPositionState() {
        position = defaultCameraPosition
    }
    var isMapLoaded by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMapView(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded = true
            }
        )
        if (!isMapLoaded) {
            AnimatedVisibility(
                visible = !isMapLoaded,
                enter = EnterTransition.None,
                modifier = Modifier.matchParentSize(),
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .wrapContentSize()
                )
            }
        }
    }
}

@Composable
fun GoogleMapView(
    modifier: Modifier = Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoaded: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val SenaCbaState = rememberMarkerState(position = SenaCBA)
    val bloqueBState = rememberMarkerState(position = bloqueB)
    val bloqueCState = rememberMarkerState(position = bloqueC)
    val ConejeraState = rememberMarkerState(position = Conejera)
    val GalponState = rememberMarkerState(position = Galpon)


    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = modifier,
            cameraPositionState = cameraPositionState,
            onMapLoaded = onMapLoaded
        ) {
//            Entrada del sena
            Marker(
                state = SenaCbaState,
                title = "Centro Biotecnologico Agropecurio"
            )
//            Bloque b
            MarkerInfoWindowContent(
                state = bloqueBState,
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
            ) {
                Text(text = "Bloque B del Sena", color = Color.Black)
            }
//            Bloque c
            MarkerInfoWindowContent(
                state = bloqueCState,
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
            ) {
                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colors.onPrimary,
                        shape = RoundedCornerShape(35.dp, 35.dp, 35.dp, 35.dp)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bg_sena),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = "Bloque C del Sena",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.primary
                        )
                    }
                }
            }
//            Conejera
            MarkerInfoWindowContent(
                state = ConejeraState,
                icon = BitmapDescriptorFactory.fromResource(R.drawable.conejo)
            ) {
                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colors.onPrimary,
                        shape = RoundedCornerShape(35.dp, 35.dp, 35.dp, 35.dp)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_conejera),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = "La Conejera",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.primary
                        )
                    }
                }
            }
//            Galpones
            MarkerInfoWindowContent(
                state = GalponState,
                icon = BitmapDescriptorFactory.fromResource(R.drawable.po_pollo)
            ) {
                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colors.onPrimary,
                        shape = RoundedCornerShape(35.dp, 35.dp, 35.dp, 35.dp)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_galpon),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = "Galpon",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.primary
                        )
                    }
                }
            }
            content()
        }
        ScaleBar(
            cameraPositionState = cameraPositionState,
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopEnd)
        )
        DisappearingScaleBar(
            cameraPositionState = cameraPositionState,
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(
                    Alignment.TopStart
                )
        )
    }
}
