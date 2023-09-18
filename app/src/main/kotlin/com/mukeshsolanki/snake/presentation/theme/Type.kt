package com.mukeshsolanki.snake.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mukeshsolanki.snake.R

private val appFontFamily = FontFamily(fonts = listOf(Font(resId = R.font.snake)))

val Typography = Typography(
    /*Este estilo se aplicará a elementos de encabezado de gran tamaño en la interfaz de usuario.*/
    displayLarge = TextStyle(

        /*fontFamily - Se establece el tipo de fuente del texto a appFontFamily, que debe ser definido
        previamente en el código. Esta propiedad determina la fuente tipográfica que se utilizará para
        el texto en el nivel de encabezado.*/
        fontFamily = appFontFamily,

        /*fontWeight - Se establece el grosor de la fuente del texto a FontWeight.Normal. Esta
        propiedad controla la densidad visual del texto, y en este caso se utiliza el grosor normal.*/
        fontWeight = FontWeight.Normal,

        /*fontSize - Se establece el tamaño de fuente del texto a 57.sp. Aquí, sp (scaled pixels) es una
        unidad de tamaño de fuente que se ajusta automáticamente según la configuración de tamaño de fuente
        del dispositivo. El valor 57.sp indica que se desea un tamaño de fuente de 57 puntos de escala.*/
        fontSize = 57.sp,
    ),
//    displayMedium = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 45.sp,
//    ),
//    displaySmall = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 36.sp,
//    ),
//    headlineLarge = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 32.sp,
//    ),
//    headlineMedium = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 28.sp,
//    ),
//    headlineSmall = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 24.sp,
//    ),
    /*Este estilo se aplicará a elementos de encabezado de tamaño grande en la interfaz de usuario.*/
    titleLarge = TextStyle(
        /*fontFamily - Se establece el tipo de fuente del texto a appFontFamily, que debe ser definido previamente en el código.
        Esta propiedad determina la fuente tipográfica que se utilizará para el texto en el nivel de encabezado.*/
        fontFamily = appFontFamily,

        /*fontWeight - Se establece el grosor de la fuente del texto a FontWeight.Normal.
        Esta propiedad controla la densidad visual del texto, y en este caso se utiliza el grosor normal.*/
        fontWeight = FontWeight.Normal,

        /*fontSize - Se establece el tamaño de fuente del texto a 22.sp. Aquí, sp (scaled pixels) es una
        unidad de tamaño de fuente que se ajusta automáticamente según la configuración de tamaño de fuente
        del dispositivo. El valor 22.sp indica que se desea un tamaño de fuente de 22 puntos de escala.*/
        fontSize = 22.sp,
    ),
//    titleMedium = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 16.sp,
//    ),
//    titleSmall = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 14.sp,
//    ),
//    bodyLarge = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//    ),
//    bodyMedium = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 14.sp,
//    ),
//    bodySmall = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp,
//    ),
//    labelLarge = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 14.sp,
//    ),
//    labelMedium = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 12.sp,
//    ),
//    labelSmall = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//    ),
)