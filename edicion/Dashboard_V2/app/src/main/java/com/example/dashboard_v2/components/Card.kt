package com.example.dashboard_v2.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.dashboard_v2.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColumnCards(
    @DrawableRes imgbody: Int,
    @StringRes textbody: Int,
    @StringRes detallebody: Int,
    modifier: Modifier = Modifier
) {
    val openDialog = remember { mutableStateOf(false) }

    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width=1.dp, color=Color.Gray)
    ) {
        Column() {
            //Cuerpo
            Image(
                painter=painterResource(imgbody),
                contentDescription="Imagenes",
                contentScale=ContentScale.Crop,
                modifier= Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(RectangleShape)
            )
            Row(Modifier.padding(start=16.dp, end=20.dp, top=16.dp)) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text=stringResource(textbody),
                        maxLines=4,
                        overflow=TextOverflow.Ellipsis,
                        style=MaterialTheme.typography.body2
                    )
                }
            }
            Row(Modifier.padding(start=16.dp, end=20.dp, top=16.dp)) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text=stringResource(detallebody),
                        maxLines=4,
                        overflow=TextOverflow.Ellipsis,
                        style=MaterialTheme.typography.body2
                    )
                }
            }
            Spacer(modifier.height(10.dp))

            //Pie
            CompositionLocalProvider(
                LocalContentAlpha provides ContentAlpha.medium,
                LocalMinimumTouchTargetEnforcement provides false
            ) {

                Row() {

                    Column(
                        modifier= Modifier
                            .align(Alignment.CenterVertically)
                            .padding(
                                15.dp
                            )
                    ) {
                        Row() {

                            TextButton(onClick={openDialog.value=true}) {
                                Text(text="Detalle")
                            }
                        }
                    }
                }
            }
        }
    }

    if (openDialog.value) {
        Dialog(onDismissRequest={openDialog.value=false}) {
            Surface(

                color = Color(0xFF8DDD66),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 90.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 90.dp
                ),

            ) {
                Column() {
                    Box {
                        Image(
                            painterResource(imgbody),
                            contentDescription = null,
                            modifier = Modifier
                                .height(260.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier

                                .background(Color.Green.copy(alpha = 0.5f))
                                .fillMaxWidth(),
                        ) {
                            Text(
                                text = stringResource(textbody),
                                modifier = Modifier
                                    .align(Alignment.TopCenter)
                                    .padding(16.dp),
                                style = MaterialTheme.typography.h4,

                                color = MaterialTheme.colors.onBackground
                            )
                        }

                    }
                    Spacer(modifier.height(16.dp))
                    Text(
                        text = stringResource(detallebody),
                        modifier.padding(16.dp),
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier.height(16.dp))
                    Box(modifier = Modifier.padding(16.dp)
                        .fillMaxWidth()) {
                        Button(
                            onClick = { openDialog.value = false },
                            modifier = Modifier.clip(
                                RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 0.dp,
                                    bottomStart = 110.dp
                                )
                            )
                                .fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_right_arrow),
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Filas(collection: List<DrawableStringQuintuple>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(
            collection
        ) { item ->
            ColumnCards(
                item.imgbody,
                item.textbody,
                item.detallebody
            )
        }
    }
}


data class Quintuple(

    @DrawableRes val imgbody: Int,
    @StringRes val textbody: Int,
    @StringRes val detallebody: Int

)

data class DrawableStringQuintuple(
    val imgbody: Int,
    val textbody: Int,
    val detallebody: Int
)


