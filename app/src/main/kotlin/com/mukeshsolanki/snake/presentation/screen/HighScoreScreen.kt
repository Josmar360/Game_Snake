package com.mukeshsolanki.snake.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.data.cache.GameCache
import com.mukeshsolanki.snake.data.model.PuntuacionAlta
import com.mukeshsolanki.snake.domain.base.TOP_3
import com.mukeshsolanki.snake.presentation.component.AppBar
import com.mukeshsolanki.snake.presentation.component.TitleLarge
import com.mukeshsolanki.snake.presentation.theme.border2dp
import com.mukeshsolanki.snake.presentation.theme.padding16dp
import com.mukeshsolanki.snake.presentation.theme.padding8dp

@Composable
/*este código define una pantalla de puntuaciones altas en un juego utilizando Jetpack Compose. Muestra las tres mejores
puntuaciones en una lista desplazable, con encabezados de columna y un título en la barra de aplicación.*/
fun HighScoreScreen(navController: NavHostController) {
    /*El código crea una instancia de GameCache para interactuar con el almacenamiento de datos del juego utilizando el contexto actual.*/
    val dataStore = GameCache(LocalContext.current)

    /*Este código obtiene la lista de puntuaciones altas del almacenamiento de datos del juego, la ordena de forma descendente según el
    puntaje y toma las tres mejores puntuaciones para asignarlas a la variable highScores.*/
    val highScores =
        dataStore.getAltaPuntuacion.collectAsState(initial = listOf()).value.sortedByDescending { it.Puntuacion }
            .take(TOP_3)

    /*Este código crea una barra de aplicación en la pantalla de puntuaciones altas del juego, con un título y un botón de retroceso.
    El contenido de la barra de aplicación está envuelto en un componente Column con relleno y borde.*/
    AppBar(
        /*title: Utiliza la función stringResource para obtener el texto del recurso de cadena con el
        ID R.string.Tabla_Puntuaciones. Esto establece el título de la barra de aplicación.*/
        title = stringResource(R.string.Tabla_Puntuaciones),

        /*onBackClicked: Es una función lambda que se ejecutará cuando se haga clic en el botón de retroceso en la barra de aplicación.
        En este caso, llama al método popBackStack() en el navController para navegar hacia atrás.*/
        onBackClicked = { navController.popBackStack() }) { contentPadding ->
        Column(
            modifier = Modifier
                    /*Modifier.fillMaxSize(): Hace que la columna ocupe tdo el espacio disponible en su contenedor.*/
                .fillMaxSize()
                    /*Agrega un relleno a los bordes de la columna. Los valores específicos de relleno se definen en los parámetros de la función*/
                .padding(
                    /*Establece el valor de relleno superior para el componente. Utiliza la función calculateTopPadding() en el parámetro contentPadding, que se proporciona
                    como argumento en la lambda de la columna ({ contentPadding -> ... }). */

                    top = contentPadding.calculateTopPadding(),
                    /* Establece el valor de relleno inferior para el componente. Utiliza el valor padding16dp, que probablemente es una constante o recurso definido en otro lugar
                    del código, y representa el tamaño deseado del relleno en unidades de densidad de píxeles (dp).*/
                    bottom = padding16dp,

                    /* Establece el valor de relleno izquierdo (start) para el componente. Utiliza el mismo valor de relleno padding16dp que se utiliza para el relleno inferior.*/
                    start = padding16dp,

                    /*Establece el valor de relleno derecho (end) para el componente. Utiliza el mismo valor de relleno padding16dp que se utiliza para el relleno inferior.*/
                    end = padding16dp
                )

                /* este código configura el ancho y color del borde para un componente en Jetpack Compose.*/
                .border(width = border2dp, color = MaterialTheme.colorScheme.onBackground),
        ) {
            /*Este código crea una fila que se extiende horizontalmente y ocupa tdo el ancho disponible en la pantalla
            de puntuaciones altas del juego. Además, se aplica un relleno a los bordes de la fila.*/
            Row(
                Modifier
                        /*Modifier.fillMaxWidth(): Hace que la fila ocupe tdo el ancho disponible en su contenedor.*/
                    .fillMaxWidth()
                        /*Modifier.padding(padding16dp): Agrega un relleno a los bordes de la fila, utilizando el valor padding16dp que está definido en otro lugar del código.*/
                    .padding(padding16dp)
            ) {
                /*este código crea un componente TitleLarge dentro de una fila y configura su texto,
                el modificador de peso para la distribución del espacio y la alineación del texto*/
                TitleLarge(
                    /*Establece el texto del componente TitleLarge utilizando la función stringResource para
                    obtener el texto del recurso de cadena con el ID R.string.Nombre_Jugador.
                    Este recurso de cadena contiene el texto "Nombre Jugador" o algo similar.*/
                    text = stringResource(R.string.Nombre_Jugador),

                    /*Configura el modificador del componente TitleLarge. En este caso, utiliza el modificador weight
                    con un valor de 1f, lo que significa que el componente ocupará una parte igual de espacio horizontal
                    dentro de su contenedor en relación con otros componentes en la misma fila.*/
                    modifier = Modifier.weight(1f),

                    /*Configura la alineación del texto dentro del componente TitleLarge. En este caso, se establece en
                    TextAlign.Center, lo que significa que el texto se alineará en el centro horizontalmente dentro del componente.*/
                    textAlign = TextAlign.Center
                )

                /*Este código crea un componente TitleLarge dentro de una fila y configura su texto, el modificador de peso para la distribución del espacio y la alineación del texto. */
                TitleLarge(
                    /* Establece el texto del componente TitleLarge utilizando la función stringResource para obtener el texto del recurso
                    de cadena con el ID R.string.Puntuacion. Este recurso de cadena contiene el texto "Puntuación" o algo similar.*/
                    text = stringResource(R.string.Puntuacion),

                    /*Configura el modificador del componente TitleLarge. En este caso, utiliza el modificador weight con un valor de 1f,
                    lo que significa que el componente ocupará una parte igual de espacio horizontal dentro de su contenedor en relación
                    con otros componentes en la misma fila.*/
                    modifier = Modifier.weight(1f),

                    /*Configura la alineación del texto dentro del componente TitleLarge. En este caso, se establece en TextAlign.Center,
                    lo que significa que el texto se alineará en el centro horizontalmente dentro del componente.*/
                    textAlign = TextAlign.Center
                )
            }
            /*Este código crea un componente LazyColumn que ocupará tdo el espacio disponible en su contenedor y genera una lista
            de componentes HighScoreItem basada en la lista de elementos highScores.*/
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                /*Especifica la lista de elementos (highScores) que se utilizará para generar
                los componentes HighScoreItem. Cada elemento de la lista se pasará como argumento a la función lambda.*/
                items(items = highScores) {
                    /*Crea un componente HighScoreItem para cada elemento de la lista.
                    El parámetro it se refiere a cada elemento de la lista en cada iteración.*/
                    HighScoreItem(it)
                }
            }
        }
    }

}

@Composable
/*Este código define una pantalla de puntuaciones altas en un juego que muestra las tres mejores puntuaciones
ordenadas por puntaje, con una barra de aplicación en la parte superior y una lista desplazable de puntuaciones
en el resto de la pantalla.*/
private fun HighScoreItem(highScore: PuntuacionAlta) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(padding8dp)
    ) {
        TitleLarge(
            text = highScore.Nombre_Jugador,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        TitleLarge(
            text = highScore.Puntuacion.toString(),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
    }
}