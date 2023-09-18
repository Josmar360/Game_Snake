package com.mukeshsolanki.snake.presentation.screen

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.mukeshsolanki.snake.BuildConfig
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.domain.base.REPO_URL
import com.mukeshsolanki.snake.presentation.component.*
import com.mukeshsolanki.snake.presentation.theme.border2dp
import com.mukeshsolanki.snake.presentation.theme.padding16dp
import com.mukeshsolanki.snake.presentation.theme.padding8dp
import com.mukeshsolanki.snake.presentation.theme.width248dp

@Composable
/*Dsta función crea una pantalla de "Acerca de" en la que se muestra información sobre la aplicación, incluyendo
el nombre, la versión y una descripción del juego. También se proporciona un botón para abrir el enlace al repositorio
de código fuente de la aplicación.*/
fun AboutScreen(navController: NavHostController) {
    /*la variable context se utiliza para pasar el contexto a otras funciones o clases que lo necesiten, como en la creación de un CustomTabsIntent para abrir
    enlaces web en un navegador externo*/
    val context = LocalContext.current

    /*CustomTabsIntent.Builder es una clase proporcionada por el sistema Android que se utiliza para construir una intención personalizada para abrir enlaces
    web en un navegador externo, conocido como Chrome Custom Tabs.*/
    val builder = remember { CustomTabsIntent.Builder() }

    /*CustomTabsIntent es una clase proporcionada por el sistema Android que representa una intención personalizada para abrir enlaces web en un navegador externo,
    conocido como Chrome Custom Tabs*/
    val customTabsIntent = remember { builder.build() }

    /*El código crea una barra de aplicación con un título obtenido del recurso de cadena y configura el comportamiento
    del botón de retroceso para volver atrás en la navegación cuando se hace clic en él.*/
    AppBar(
        /*title = stringResource(R.string.Sobre_Titulo): Establece el título de la barra de aplicación utilizando el recurso
        de cadena con el identificador R.string.Sobre_Titulo. El valor del recurso de cadena se obtiene utilizando la función stringResource().*/
        title = stringResource(R.string.Sobre_Titulo),

        /*onBackClicked = { navController.popBackStack() }: Define el comportamiento del evento de retroceso (back) cuando se hace clic en el botón
        de retroceso de la barra de aplicación. En este caso, se utiliza navController.popBackStack() para navegar hacia atrás en la pila de destinos de navegación.*/
        onBackClicked = { navController.popBackStack() }) {

        /*Este código crea un Column que ocupa el espacio disponible en su contenedor padre, con márgenes y un borde
        específicos. Los elementos dentro del Column se alinearán tanto horizontal como verticalmente en el centro.*/
        Column(
            /*modifier: Se le aplican varios modificadores para controlar su tamaño */
            modifier = Modifier

                .fillMaxSize()

                /*Este código establece un espacio de relleno alrededor del composable Column, con valores específicos
                para el espacio de relleno superior, inferior, izquierdo y derecho*/
                .padding(
                    /*top = it.calculateTopPadding(): El valor top se establece en it.calculateTopPadding(), lo cual
                    indica que se utilizará un valor calculado para el espacio de relleno superior. El cálculo del espacio de
                    relleno superior puede depender del tema o del diseño específico de la aplicación.*/
                    top = it.calculateTopPadding(),

                    /*bottom = padding16dp: El valor bottom se establece en padding16dp, lo que significa que se aplicará un
                    espacio de relleno de 16 unidades de densidad de píxeles (dp) en la parte inferior.*/
                    bottom = padding16dp,

                    /*start = padding16dp: El valor start se establece en padding16dp, lo que indica que se aplicará un
                    espacio de relleno de 16 dp en el borde izquierdo (para lenguajes de escritura de izquierda a derecha).*/
                    start = padding16dp,

                    /*end = padding16dp: El valor end se establece en padding16dp, lo que indica que se aplicará un espacio
                    de relleno de 16 dp en el borde derecho (para lenguajes de escritura de izquierda a derecha).*/
                    end = padding16dp
                )
                /*.border(width = border2dp, color = MaterialTheme.colorScheme.onBackground): Este modificador border se
                utiliza para agregar un borde al composable Column. El borde tendrá un ancho de border2dp y un color especificado
                por MaterialTheme.colorScheme.onBackground.*/
                .border(width = border2dp, color = MaterialTheme.colorScheme.onBackground),

            /*horizontalAlignment = Alignment.CenterHorizontally: Este parámetro establece la alineación horizontal del
            contenido del Column. En este caso, el contenido se centrará horizontalmente.*/
            horizontalAlignment = Alignment.CenterHorizontally,

            /*verticalArrangement = Arrangement.Center: Este parámetro establece el arreglo vertical del contenido del
            Column. En este caso, el contenido se centrará verticalmente.*/
            verticalArrangement = Arrangement.Center

        ) {
            /*Este código crea dos componentes de texto, uno para mostrar el nombre de la aplicación y otro para mostrar
            el nombre de la versión de la aplicación. Ambos componentes tienen estilos visuales diferentes y pueden tener
            modificadores de diseño para controlar su apariencia y posición en la interfaz de usuario.*/
            DisplayLarge(text = stringResource(id = R.string.Nombre_App))

            /*El componente TitleLarge muestra un texto grande utilizando la propiedad BuildConfig.VERSION_NAME. Esta
            propiedad representa el nombre de la versión de la aplicación obtenida del archivo BuildConfig. El contenido
            de esta propiedad se mostrará en el componente.*/
            TitleLarge(
                /*modifier: Se aplica un modificador padding() con el valor padding8dp. Este modificador establece un
                espacio de relleno alrededor del componente de texto.*/
                modifier = Modifier.padding(padding8dp),
                /*text: Se le pasa el valor BuildConfig.VERSION_NAME como texto del componente. BuildConfig.VERSION_NAME
                es una constante que generalmente se utiliza para almacenar la versión de la aplicación*/
                text = BuildConfig.VERSION_NAME
            )

            /*Este código crea un componente de texto grande con un relleno de 16dp y muestra el contenido de la cadena de
            recursos "Sobre_El_Juego". El texto se justificará para que tenga un aspecto más estético en términos de alineación.*/
            BodyLarge(
                modifier = Modifier.padding(padding16dp),
                /*El componente tiene un modificador modifier que agrega un relleno de padding16dp. Esto significa que se aplicará
                un espacio de relleno de 16 puntos densidad de píxeles (dp) alrededor del componente.*/

                /*El texto del componente se obtiene de una cadena de recursos utilizando stringResource(R.string.Sobre_El_Juego).
                El valor de la cadena se mostrará en el componente.*/
                text = stringResource(R.string.Sobre_El_Juego),

                /*El componente tiene una propiedad textAlign establecida en TextAlign.Justify. Esto indica que el texto se justificará,
                lo que significa que el espacio en blanco se distribuirá uniformemente entre las palabras para que los bordes izquierdo
                y derecho del texto estén alineados.*/
                textAlign = TextAlign.Justify
            )

            /*Este código crea un botón que muestra el texto "source_code" y al hacer clic en él, se abrirá
            la URL del repositorio de código fuente de la aplicación en el navegador utilizando customTabsIntent.*/
            AppButton(
                /*El botón tiene un modificador modifier que establece el ancho del botón en width248dp.
                Esto indica que el botón tendrá un ancho de 248 puntos densidad de píxeles (dp).*/
                modifier = Modifier.width(width248dp),

                /*El texto del botón se obtiene de una cadena de recursos utilizando
                stringResource(R.string.source_code). El valor de la cadena se mostrará en el botón.*/
                text = stringResource(R.string.source_code)
            )

            /*El botón tiene un bloque de código de acción que se ejecutará cuando se haga clic en él.
            En este caso, el código utiliza customTabsIntent.launchUrl(context, Uri.parse(REPO_URL)).
            Esto lanzará una intención para abrir una URL en el navegador. La URL se obtiene de la constante REPO_URL,
            que es una cadena que representa el enlace al repositorio de código fuente de la aplicación.*/
            { customTabsIntent.launchUrl(context, Uri.parse(REPO_URL)) }
        }
    }
}