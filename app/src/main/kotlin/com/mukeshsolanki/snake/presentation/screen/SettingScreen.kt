package com.mukeshsolanki.snake.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.data.cache.GameCache
import com.mukeshsolanki.snake.presentation.component.AppBar
import com.mukeshsolanki.snake.presentation.component.AppButton
import com.mukeshsolanki.snake.presentation.component.DisplayLarge
import com.mukeshsolanki.snake.presentation.theme.border2dp
import com.mukeshsolanki.snake.presentation.theme.padding16dp
import com.mukeshsolanki.snake.presentation.theme.padding64dp
import com.mukeshsolanki.snake.presentation.theme.width248dp
import kotlinx.coroutines.launch

@Composable
/*Este código muestra una pantalla de configuración donde el usuario puede ingresar y guardar el nombre del jugador.*/
fun SettingScreen(navController: NavHostController) {
    /*El código crea una instancia de GameCache utilizando el contexto local actual, lo que sugiere que se está configurando
    y utilizando un mecanismo de almacenamiento de datos específico para el juego.*/
    val dataStore = GameCache(LocalContext.current)

    /*Crea una variable mutable llamada text que almacena el estado de un campo de texto en la pantalla.*/
    var text by remember { mutableStateOf(TextFieldValue("")) }

    /*Crea una instancia de CoroutineScope utilizando la función rememberCoroutineScope().*/
    val scope = rememberCoroutineScope()

    /*Crea una instancia de FocusRequester utilizando la función remember.*/
    val focusRequester = remember { FocusRequester() }

    /*Obtiene el contexto actual utilizando la función LocalContext.current de Jetpack Compose.*/
    val context = LocalContext.current

    /*este código crea una barra de aplicaciones con un título y un botón de retroceso. Cuando se hace
    clic en el botón de retroceso, la aplicación navegará hacia atrás en la jerarquía de fragmentos.*/
    AppBar(
        /* Establece el título de la barra de aplicaciones utilizando una cadena de recursos definida
        en el archivo de recursos de la aplicación. El valor R.string.Configuracion_Titulo hace referencia
        al identificador de la cadena en el archivo de recursos y se usa para obtener el valor real de la
        cadena en tiempo de ejecución.*/
        title = stringResource(R.string.Configuracion_Titulo),

        /*Define la acción a realizar cuando se hace clic en el botón de retroceso de la barra de aplicaciones.
        En este caso, se llama al método popBackStack() del navController para navegar hacia atrás en la pila de
        fragmentos y regresar a la pantalla anterior.*/
        onBackClicked = { navController.popBackStack() }) {
        Column(
            modifier = Modifier
                    /*Establece un modificador para que la columna ocupe tdo el tamaño disponible en su contenedor.
                    Esto permite que la columna se expanda verticalmente para llenar el espacio disponible.*/
                .fillMaxSize()
                    /*Establece un modificador para agregar espacios de relleno (padding) alrededor de la columna.
                    En este caso, se utiliza el método */
                .padding(
                    /*Este código establece el valor de relleno en la dirección superior del elemento. El valor se
                    obtiene llamando al método calculateTopPadding() en it, que es el contexto o el objeto del elemento
                    en el que se aplica el modificador. El método calculateTopPadding() podría ser una función personalizada
                    que calcula el valor de relleno superior en función de algún contexto o lógica específica de la aplicación.*/
                    top = it.calculateTopPadding(),

                    /*Este código establece el valor de relleno en la dirección inferior del elemento. El valor padding16dp
                    puede ser una constante que representa un tamaño de relleno de 16 unidades de densidad de píxeles (dp).*/
                    bottom = padding16dp,

                    /*Este código establece el valor de relleno en la dirección izquierda del elemento. El valor padding16dp
                    puede ser una constante que representa un tamaño de relleno de 16 unidades de densidad de píxeles (dp).*/
                    start = padding16dp,

                    /*ste código establece el valor de relleno en la dirección derecha del elemento. El valor padding16dp
                    puede ser una constante que representa un tamaño de relleno de 16 unidades de densidad de píxeles (dp).*/
                    end = padding16dp
                )
                    /*este código configura un modificador de borde alrededor del elemento. Establece el ancho del borde
                    y el color del borde utilizando valores proporcionados, lo que permite definir los estilos visuales y
                    las características de diseño del elemento en cuestión.*/
                .border(width = border2dp, color = MaterialTheme.colorScheme.onBackground),

            /*Establece la alineación horizontal de los elementos dentro de la columna. En este caso, se utiliza
            Alignment.CenterHorizontally para centrar los elementos horizontalmente en la columna.*/
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            /*Este código crea un componente personalizado DisplayLarge con un modificador de relleno para ajustar los espacios
             alrededor del componente, establece el texto del componente utilizando una cadena de recursos y configura la
             alineación del texto dentro del componente*/
            DisplayLarge(
                /*Este código establece un modificador de relleno (padding) en el elemento al que se aplica. El modificador
                padding() se utiliza para agregar espacios de relleno alrededor del elemento.*/
                modifier = Modifier.padding(
                    /*Este código establece el valor de relleno en la dirección superior del elemento. El valor padding64dp
                    puede ser una constante que representa un tamaño de relleno de 64 unidades de densidad de píxeles (dp).*/
                    top = padding64dp,

                    /*Este código establece el valor de relleno en la dirección inferior del elemento. El valor padding16dp
                    puede ser una constante que representa un tamaño de relleno de 16 unidades de densidad de píxeles (dp).*/
                    bottom = padding16dp,

                    /*Este código establece el valor de relleno en la dirección izquierda del elemento. El valor padding16dp
                    puede ser una constante que representa un tamaño de relleno de 16 unidades de densidad de píxeles (dp).*/
                    start = padding16dp,

                    /*Este código establece el valor de relleno en la dirección derecha del elemento. El valor padding16dp
                    puede ser una constante que representa un tamaño de relleno de 16 unidades de densidad de píxeles (dp).*/
                    end = padding16dp
                ),
                /*Este código establece el texto del componente de texto utilizando una cadena de recursos definida en el archivo
                de recursos de la aplicación. El valor R.string.Nombre_Jugador hace referencia al identificador de la cadena en el
                archivo de recursos y se utiliza para obtener el valor real de la cadena en tiempo de ejecución. En este caso, se
                está estableciendo el texto del componente de texto como el valor de la cadena correspondiente al identificador Nombre_Jugador.*/
                text = stringResource(id = R.string.Nombre_Jugador),

                /*Este código establece la alineación del texto dentro del componente de texto. En este caso, el valor TextAlign.Center se utiliza
                para centrar el texto horizontalmente dentro del componente de texto. Esto significa que el texto se colocará en el centro del componente,
                alineado de manera centralizada.*/
                textAlign = TextAlign.Center
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
            /*este código crea un componente de campo de texto que muestra y permite al usuario ingresar texto.*/
            TextField(
                /* Este código establece el valor del campo de texto en la variable text. La variable text
                se utiliza para almacenar el texto ingresado por el usuario en el campo de texto.*/
                value = text,

                /*Este código establece una función lambda que se ejecutará cuando el valor del campo de texto
                cambie. Dentro de la función, se actualiza el valor de la variable text con el nuevo valor ingresado por el usuario.*/
                onValueChange = { text = it },

                /*Este código configura los colores del campo de texto. El método TextFieldDefaults.textFieldColors() se utiliza para
                establecer los colores personalizados para diferentes elementos del campo de texto, como el contenedor, el texto y el
                cursor. En este caso, se establecen los colores utilizando el esquema de colores definido en el tema de la aplicación,
                especificando el color del contenedor, el color del texto y el color del cursor.*/
                colors = TextFieldDefaults.textFieldColors(
                    /*Este código establece el color del contenedor del campo de texto. El valor se obtiene del esquema de colores
                    definido en el tema de la aplicación, más específicamente, del color de fondo (background) del esquema de colores.*/
                    containerColor = MaterialTheme.colorScheme.background,

                    /* Este código establece el color del texto del campo de texto. El valor se obtiene del esquema de colores definido
                    en el tema de la aplicación, más específicamente, del color del texto sobre el fondo (onBackground) del esquema de colores.*/
                    textColor = MaterialTheme.colorScheme.onBackground,

                    /*Este código establece el color del cursor del campo de texto. El valor se obtiene del esquema de colores
                    definido en el tema de la aplicación, más específicamente, del color del texto sobre el fondo (onBackground) del esquema de colores.*/
                    cursorColor = MaterialTheme.colorScheme.onBackground,
                ),
                /*Este código indica que el campo de texto debe tener una única línea. Esto significa que el campo de texto solo
                aceptará una línea de entrada de texto y no permitirá la entrada de múltiples líneas.*/
                singleLine = true,

                /*Este código configura los modificadores para el campo de texto. Se utilizan varios modificadores encadenados
                para configurar diferentes propiedades del campo de texto*/
                modifier = Modifier
                        /*Este modificador establece el solicitante de enfoque (focusRequester) para el campo de texto.
                        El solicitante de enfoque se utiliza para solicitar el enfoque en el campo de texto.*/
                    .focusRequester(focusRequester)

                        /*Este modificador hace que el campo de texto ocupe tdo el ancho disponible en su contenedor.*/
                    .fillMaxWidth()
                        /*Este modificador agrega espacios de relleno (padding) horizontal al campo de texto. El valor
                        padding64dp representa un tamaño de relleno de 64 unidades de densidad de píxeles (dp) en la dirección horizontal.*/
                    .padding(horizontal = padding64dp)

                        /*Este modificador agrega un borde alrededor del campo de texto. El valor border2dp representa
                        un ancho de borde de 2 unidades de densidad de píxeles (dp), y el color del borde se obtiene del
                        esquema de colores definido en el tema de la aplicación.*/
                    .border(width = border2dp, color = MaterialTheme.colorScheme.onBackground)
            )
            /*este código crea un componente personalizado de botón llamado AppButton con un texto específico y aplicando
            modificadores para configurar el ancho y el relleno del botón.*/
            AppButton(
                /*Este código establece el texto del botón utilizando una cadena de recursos definida en el archivo de recursos
                de la aplicación. El valor R.string.Guardar hace referencia al identificador de la cadena en el archivo de recursos
                y se utiliza para obtener el valor real de la cadena en tiempo de ejecución. En este caso, se establece el texto del
                botón como el valor de la cadena correspondiente al identificador Guardar.*/
                text = stringResource(R.string.Guardar), modifier = Modifier
                        /*Este modificador establece el ancho del botón utilizando el valor width248dp. Este valor representa un ancho
                        de 248 unidades de densidad de píxeles (dp) y se utiliza para especificar el ancho del botón.*/
                    .width(width248dp)

                        /*Este modificador agrega espacios de relleno (padding) alrededor del botón. El valor padding16dp
                        representa un tamaño de relleno de 16 unidades de densidad de píxeles (dp) y se utiliza para establecer
                        los espacios de relleno en todas las direcciones del botón.*/
                    .padding(padding16dp)
            ) {
                /*Este código inicia una nueva coroutine en el ámbito (scope) actual. Una coroutine es una forma de realizar
                tareas asíncronas y concurrentes de manera estructurada en Kotlin. El bloque de código dentro de la coroutine se
                ejecutará en segundo plano de manera asíncrona.*/
                scope.launch {
                    /*Dentro de la coroutine, se llama al método saveNombreJugador() en el objeto dataStore. Este código guarda
                    el nombre del jugador en algún tipo de almacenamiento de datos, posiblemente utilizando la API de DataStore en
                    Android. El valor del nombre del jugador se obtiene del campo de texto text, y el método trim() se utiliza para
                    eliminar los espacios en blanco al principio y al final del texto ingresado.*/
                    dataStore.saveNombreJugador(text.text.trim())

                    /*Este código muestra un mensaje emergente (toast) en la interfaz de usuario para indicar que el nombre del jugador
                    ha sido actualizado. El mensaje del toast se obtiene de la cadena de recursos R.string.Nombre_Jugador_Actualizado.
                    El contexto (context) se utiliza para mostrar el toast y Toast.LENGTH_SHORT indica la duración corta del toast.*/
                    Toast.makeText(context, R.string.Nombre_Jugador_Actualizado, Toast.LENGTH_SHORT).show()

                    /* Este código realiza una navegación hacia atrás en el controlador de navegación (navController). En otras
                    palabras, retrocede a la pantalla anterior en la pila de navegación.*/
                    navController.popBackStack()
                }
            }
        }
    }
}