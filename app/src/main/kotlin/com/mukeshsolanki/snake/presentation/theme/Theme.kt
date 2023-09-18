package com.mukeshsolanki.snake.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/*La línea de código private val colorScheme = darkColorScheme(...) crea una instancia de un esquema
de colores utilizando la función darkColorScheme. Esta función se utiliza para definir un esquema de
colores para un tema oscuro en Jetpack Compose.*/
private val colorScheme = darkColorScheme(
    /*primary, secondary y tertiary se establecen en DarkGreen, lo que indica que el color principal,
    secundario y terciario en el esquema de colores son de color verde oscuro.*/
    primary = DarkGreen,
    secondary = DarkGreen,
    tertiary = DarkGreen,

    /*background se establece en LightGreen, lo que indica que el color de fondo en el esquema de colores es de color verde claro.*/
    background = LightGreen,

    /*onPrimary se establece en Color.White, lo que indica que el color del texto o contenido que se
    muestra sobre el color principal en el esquema de colores es blanco.*/
    onPrimary = Color.White,

    /*onBackground se establece en DarkGreen, lo que indica que el color del texto o contenido que
    se muestra sobre el color de fondo en el esquema de colores es verde oscuro.*/
    onBackground = DarkGreen
)

@Composable
/*La función SnakeTheme envuelve el contenido de la interfaz de usuario proporcionado en un tema personalizado
que define colores y tipografía personalizados. Esto permite aplicar un aspecto y una sensación coherentes en toda
la interfaz de usuario de la aplicación cuando se utiliza este tema.*/
fun SnakeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        /*colorScheme - Se utiliza el esquema de colores definido previamente (probablemente con la función darkColorScheme)
        para especificar los colores del tema. Este esquema de colores personalizado define diferentes valores de color para
        diversas propiedades, como el color principal, secundario, de fondo, etc.*/
        colorScheme = colorScheme,

        /*typography - Se utiliza el objeto Typography para definir la tipografía del tema. Este objeto contiene las configuraciones
        de estilo de texto para los diferentes niveles de encabezado, texto de cuerpo, etc.*/
        typography = Typography,

        /*content - Se pasa el contenido de la interfaz de usuario proporcionado como parámetro a la función MaterialTheme.
        Este contenido se renderizará dentro del tema personalizado con los colores y la tipografía especificados.*/
        content = content
    )
}