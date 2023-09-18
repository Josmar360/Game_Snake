package com.mukeshsolanki.snake.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.presentation.activity.GameActivity
import com.mukeshsolanki.snake.presentation.component.AppBar
import com.mukeshsolanki.snake.presentation.component.AppButton
import com.mukeshsolanki.snake.presentation.component.DisplayLarge
import com.mukeshsolanki.snake.presentation.component.TitleLarge
import com.mukeshsolanki.snake.presentation.theme.padding8dp

@Composable
/*El código define la estructura y contenido de la pantalla de fin de juego, mostrando la puntuación
obtenida por el jugador y proporcionando la opción de intentar nuevamente el juego.*/
fun EndScreen(score: Int, onTryAgain: () -> Unit) {
    /*Esta línea de código permite obtener la instancia de la actividad actual para poder controlar su finalización en el contexto de la función EndScreen.*/
    val activity = LocalContext.current as GameActivity

    /*El código define una AppBar con un título vacío y un botón de retroceso que finaliza la actividad actual. El contenido
    de la AppBar consiste en una columna centrada vertical y horizontalmente, que se puede personalizar con otros elementos
    según sea necesario.*/
    AppBar(title = "", onBackClicked = { activity.finish() }) { contentPadding ->
        Column(
            modifier = Modifier
                    /*El modificador fillMaxSize() indica que el contenedor Column debe ocupar tdo el espacio disponible en su padre. Esto permite que la columna se expanda para ocupar todo el espacio vertical y horizontalmente.*/
                .fillMaxSize()

                    /*El modificador Modifier.padding(contentPadding) agrega un espacio de relleno alrededor de la columna. El valor de contentPadding es proporcionado por el contenedor que envuelve esta columna (en este caso, la AppBar).*/
                .padding(contentPadding),
            /*El parámetro horizontalAlignment = Alignment.CenterHorizontally alinea los elementos de la columna horizontalmente en el centro.*/

            horizontalAlignment = Alignment.CenterHorizontally,
            /*El parámetro verticalArrangement = Arrangement.Center alinea los elementos de la columna verticalmente en el centro.*/

            verticalArrangement = Arrangement.Center
        ) {
            /*El código crea un componente de texto grande con un relleno específico, muestra la cadena de recursos "Fin_Partida"
            y lo alinea en el centro de la pantalla.*/
            DisplayLarge(
                /*El modificador Modifier.padding(padding8dp) agrega un espacio de relleno alrededor del componente de texto.*/
                modifier = Modifier.padding(padding8dp),

                /*El parámetro text recibe el texto a mostrar, que se obtiene a través de la función stringResource(R.string.Fin_Partida).
                El texto se obtiene del archivo de recursos y se utiliza la cadena asociada al identificador "R.string.Fin_Partida".*/
                text = stringResource(R.string.Fin_Partida),

                /*El parámetro textAlign = TextAlign.Center establece la alineación del texto en el centro.*/
                textAlign = TextAlign.Center
            )
            /*El componente TitleLarge utiliza el estilo de tipografía titleLarge definido en el tema de Material Design para mostrar el
            texto con un tamaño y estilo adecuados para un título grande.*/
            TitleLarge(
                /*El modificador padding(padding8dp) agrega un espacio de relleno alrededor del componente TitleLarge. El valor padding8dp
                indica un espacio de 8dp en cada dirección (arriba, abajo, izquierda, derecha).*/
                modifier = Modifier.padding(padding8dp),

                /*El parámetro text recibe una cadena de texto que se mostrará como título.*/
                text = stringResource(id = R.string.Tu_Puntuaje, score),
            )

            /*Este código crea un botón en la interfaz de usuario con el texto "Intentar nuevamente"*/
            AppButton(text = stringResource(R.string.Intentar_Nuevamente)) { onTryAgain.invoke() }
        }
    }
}