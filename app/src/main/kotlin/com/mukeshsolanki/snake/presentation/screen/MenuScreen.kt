package com.mukeshsolanki.snake.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.domain.extension.launchActivity
import com.mukeshsolanki.snake.domain.navigation.Screen
import com.mukeshsolanki.snake.presentation.activity.GameActivity
import com.mukeshsolanki.snake.presentation.component.AppButton
import com.mukeshsolanki.snake.presentation.component.DisplayLarge
import com.mukeshsolanki.snake.presentation.theme.border2dp
import com.mukeshsolanki.snake.presentation.theme.padding16dp
import com.mukeshsolanki.snake.presentation.theme.padding64dp
import com.mukeshsolanki.snake.presentation.theme.width248dp

@Composable
/*Esta función MenuScreen crea la pantalla de menú de un juego con un diseño vertical. Los elementos se
organizan en una columna centralizada horizontalmente y verticalmente. Se muestran botones con texto y
acciones asociadas para iniciar una nueva partida, ver la tabla de puntuaciones, acceder a la configuración
del juego y obtener información sobre el juego.*/
fun MenuScreen(navController: NavHostController) {
    /*Crea un componente Column en Jetpack Compose. Un Column es un contenedor que organiza sus elementos
    secuencialmente en una columna vertical. Los elementos se colocan uno debajo del otro.*/
    Column(
        modifier = Modifier
                /*indica que el componente debe ocupar tdo el espacio disponible en su contenedor.*/
            .fillMaxSize()

                /*establece un relleno de 16dp en todos los lados del componente.*/
            .padding(padding16dp)

                /*agrega un borde con un ancho determinado (border2dp) y un color obtenido del esquema de colores (MaterialTheme.colorScheme.onBackground).*/
            .border(width = border2dp, color = MaterialTheme.colorScheme.onBackground),

        /*Este parámetro establece la alineación horizontal de los elementos dentro del contenedor. En este caso, se establece
        en Alignment.CenterHorizontally, lo que significa que los elementos se centrarán horizontalmente en el contenedor.*/
        horizontalAlignment = Alignment.CenterHorizontally,

        /*Este parámetro establece la disposición vertical de los elementos dentro del contenedor. En este caso, se establece
        en Arrangement.Center, lo que significa que los elementos se centrarán verticalmente en el contenedor. */
        verticalArrangement = Arrangement.Center
    ) {
        /*se obtiene el contexto actual en el que se encuentra el código en ese momento.*/
        val context = LocalContext.current

        /*este código muestra un texto destacado o con un tamaño de fuente grande en la interfaz de usuario de la aplicación,
        utilizando el recurso de cadena con el identificador R.string.Nombre_App como contenido del texto.*/
        DisplayLarge(text = stringResource(id = R.string.Nombre_App))

        /*{ context.launchActivity<GameActivity>() }*/
        AppButton(
            modifier = Modifier
                    /*Establece el ancho del componente AppButton en un valor específico. width248dp probablemente
                    se refiere a un recurso que contiene el ancho deseado en dp.*/
                .width(width248dp)

                    /*Establece un relleno en la parte superior del componente AppButton. padding64dp se refiere
                    a un recurso que contiene la cantidad de relleno deseada en la parte superior en dp.*/
                .padding(top = padding64dp),

            /*Establece el texto del componente AppButton. Utiliza la función stringResource para obtener el valor de cadena
            correspondiente al identificador de recurso R.string.Nueva_Partida. El texto obtenido se mostrará en el botón.*/
            text = stringResource(R.string.Nueva_Partida)
        )
        /*el código intenta lanzar la actividad GameActivity cuando se realiza una acción en el botón*/
        { context.launchActivity<GameActivity>() }

        /*{ context.launchActivity<GameActivity>() }*/
        AppButton(
            /*Este modificador establece el ancho del componente AppButton en un valor específico. width248dp se
            refiere a un recurso que contiene el ancho deseado en dp. Esto determinará el tamaño horizontal del botón.*/
            modifier = Modifier.width(width248dp),

            /*Este atributo establece el texto que se mostrará en el componente AppButton. Utiliza la función stringResource
            para obtener el valor de cadena correspondiente al identificador de recurso R.string.Tabla_Puntuaciones.
            El texto obtenido se mostrará en el botón.*/
            text = stringResource(id = R.string.Tabla_Puntuaciones)
        ) {
            /*Este código permite realizar la navegación desde la pantalla actual a la pantalla de puntuaciones altas (HighScores) utilizando el navController.*/
            navController.navigate(Screen.HighScores.route)
        }

        /*{ context.launchActivity<GameActivity>() }*/
        AppButton(modifier = Modifier.width(width248dp), text = stringResource(R.string.Configuracion)) {
            /*Este código permite realizar la navegación desde la pantalla actual a la pantalla de configuracion (Settings) utilizando el navController.*/
            navController.navigate(Screen.Settings.route)
        }

        /*{ context.launchActivity<GameActivity>() }*/
        AppButton(modifier = Modifier.width(width248dp), text = stringResource(R.string.Sobre)) {
            /*Este código permite realizar la navegación desde la pantalla actual a la pantalla de Acerca de (About) utilizando el navController.*/
            navController.navigate(Screen.About.route)
        }
    }
}