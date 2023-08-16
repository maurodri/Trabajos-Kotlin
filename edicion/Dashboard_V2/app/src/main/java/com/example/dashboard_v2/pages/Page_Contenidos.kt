package com.example.dashboard_v2.pages


import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboard_v2.R
import com.example.dashboard_v2.components.DrawableStringQuintuple
import com.example.dashboard_v2.components.Filas
import com.example.dashboard_v2.components.OnBoardingData
import com.example.dashboard_v2.components.Quintuple
import com.example.dashboard_v2.ui.theme.BottomCardShape
import com.example.dashboard_v2.ui.theme.ColorBlue
import com.example.dashboard_v2.ui.theme.ColorGreen
import com.example.dashboard_v2.ui.theme.ColorYellow
import com.example.dashboard_v2.ui.theme.Poppins
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
@ExperimentalPagerApi
@Composable
fun Page_Contenidos() {
    Surface(modifier = Modifier.fillMaxSize()) {

        val items = ArrayList<OnBoardingData>()

        items.add(
            OnBoardingData(
                R.drawable.lacteos_content,
                "Lleva los mejores Lacteos",
                "Una variedad de productos lácteos de la mejor calidad. Elaborados con leche fresca y natural. Encuentras en LacteoSena.",
                backgroundColor = Color(0xFF0189C5),
                mainColor = Color(0xFF00B5EA)
            )
        )

        items.add(
            OnBoardingData(
                R.drawable.food,
                "Lleva las mejores Frutas",
                "Una selección de frutas frescas y jugosas. Cultivadas con cuidado y respeto al medio ambiente. Disfrutas en FrutiSena.",
                backgroundColor = Color(0xFFE4AF19),
                mainColor = ColorYellow
            )
        )

        items.add(
            OnBoardingData(
                R.drawable.flores_contenido,
                "Lleva las mejores Flores",
                "Una colección de flores hermosas y fragantes. Arregladas con arte y elegancia por expertos floristas. Consigues en FloreSena.",
                backgroundColor = Color(0xFF96E172),
                mainColor = ColorGreen
            )
        )


        val pagerState = rememberPagerState(
            pageCount = items.size,
            initialOffscreenLimit = 2,
            infiniteLoop = false,
            initialPage = 0,
        )


        OnBoardingPager(
            item = items, pagerState = pagerState, modifier = Modifier
                .fillMaxWidth()
                .background(color = ColorBlue)
        )

    }

}


@DelicateCoroutinesApi
@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item[page].backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    Image(
                        painter = painterResource(id = item[page].image),
                        contentDescription = item[page].title,
                        modifier = Modifier
                            .fillMaxWidth()
                    )


                }
            }

        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp),
                backgroundColor = Color.White,
                elevation = 0.dp,
                shape = BottomCardShape.large
            ) {
                Box() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        PagerIndicator(items = item, currentPage = pagerState.currentPage)
                        Text(
                            text = item[pagerState.currentPage].title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, end = 30.dp),
//                            color = Color(0xFF292D32),
                            color = item[pagerState.currentPage].mainColor,
                            fontFamily = Poppins,
                            textAlign = TextAlign.Right,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = item[pagerState.currentPage].desc,
                            modifier = Modifier.padding(top = 20.dp, start = 40.dp, end = 20.dp),
                            color = Color.Gray,
                            fontFamily = Poppins,
                            fontSize = 17.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraLight
                        )

                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 80.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {


                            if (pagerState.currentPage != 2) {
                                TextButton(onClick = {
                                    //skip
                                }) {
                                    Text(
                                        text = "Skip Now",
                                        color = Color(0xFF292D32),
                                        fontFamily = Poppins,
                                        textAlign = TextAlign.Right,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }

                                OutlinedButton(
                                    onClick = {
                                        GlobalScope.launch {
                                            pagerState.scrollToPage(
                                                pagerState.currentPage + 1,
                                                pageOffset = 0f
                                            )
                                        }
                                    },
                                    border = BorderStroke(
                                        14.dp,
                                        item[pagerState.currentPage].mainColor
                                    ),
                                    shape = RoundedCornerShape(50), // = 50% percent
                                    //or shape = CircleShape
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = item[pagerState.currentPage].mainColor),
                                    modifier = Modifier.size(65.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_right_arrow),
                                        contentDescription = "",
                                        tint = item[pagerState.currentPage].mainColor,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            } else {
                                Button(
                                    onClick = {
                                        //show home screen
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = item[pagerState.currentPage].mainColor
                                    ),
                                    contentPadding = PaddingValues(vertical = 12.dp),
                                    elevation = ButtonDefaults.elevation(
                                        defaultElevation = 0.dp
                                    )
                                ) {
                                    Text(
                                        text = "Get Started",
                                        color = Color.White,
                                        fontSize = 16.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun PagerIndicator(currentPage: Int, items: List<OnBoardingData>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        repeat(items.size) {
            Indicator(isSelected = it == currentPage, color = items[it].mainColor)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean, color: Color) {
    val width = animateDpAsState(targetValue = if (isSelected) 40.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) color else Color.Gray.copy(alpha = 0.5f)
            )
    )
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @androidx.annotation.IntRange(from = 0) pageCount: Int,
    @androidx.annotation.IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @androidx.annotation.IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

/*
private val ProgramasFormacion = listOf(
    Quintuple(
        R.drawable.deportes,
        R.string.Deportes
    ),
    Quintuple(
        R.drawable.negocios,
        R.string.Negocios
    ),
    Quintuple(

        R.drawable.adso,
        R.string.Adso
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody) }
*/

