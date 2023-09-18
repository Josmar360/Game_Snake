package com.mukeshsolanki.snake.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.mukeshsolanki.snake.presentation.theme.padding16dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
/*La función AppBar se utiliza para crear una barra de aplicación personalizada en Jetpack Compose, con un título,
un botón de retroceso y un contenido personalizado.*/
fun AppBar(
    /*title: String: Es el título de la barra de aplicación. Es un parámetro de tipo String que especifica el texto
    que se mostrará en la barra de título.*/
    title: String,

    /*onBackClicked: () -> Unit: Es una función de retorno de llamada que se invoca cuando se hace clic en el botón de
    retroceso en la barra de aplicación. Es un parámetro de tipo () -> Unit, lo que significa que no toma ningún argumento
    y no devuelve ningún valor.*/
    onBackClicked: () -> Unit,

    /*content: @Composable (padding: PaddingValues) -> Unit: Es una función lambda que define el contenido de la barra
    de aplicación. Toma un parámetro padding de tipo PaddingValues, que representa los valores de relleno alrededor del
    contenido. La función lambda no devuelve ningún valor.*/
    content: @Composable (padding: PaddingValues) -> Unit
) {
    /*Scaffold: Es un componente de Jetpack Compose que proporciona una estructura básica para la interfaz de usuario,
    incluyendo una barra de aplicación y un área de contenido. Toma varios parámetros, y en este caso, el parámetro topBar
    se utiliza para definir la barra de aplicación superior.*/
    Scaffold(topBar = {
        /*SmallTopAppBar: Es un componente personalizado que se utiliza para crear una barra de aplicación superior más pequeña.
        Toma varios parámetros, y en este caso, se utilizan los siguientes:*/
        SmallTopAppBar(
            /*title: Es una lambda que define el título de la barra de aplicación.
            En este caso, se utiliza el componente TitleLarge para mostrar un título grande.*/
            title = { TitleLarge(text = title) },

            /*navigationIcon: Es una lambda que define el icono de navegación en la barra de aplicación. En este caso, se utiliza
            el componente IconButton junto con el icono de flecha hacia atrás (ArrowBack) de los Icons.Default de Material Design.*/
            navigationIcon = {
                IconButton(onClick = onBackClicked) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            /*colors: Es un objeto que define los colores utilizados en la barra de aplicación. En este caso, se utiliza la función (MaterialTheme.colorScheme.background)*/
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                /*Establece el color de fondo del contenedor de la barra de aplicación utilizando la propiedad containerColor en el componente SmallTopAppBar.*/
                containerColor = MaterialTheme.colorScheme.background,

                /*Establece el color del contenido del título de la barra de aplicación utilizando la propiedad titleContentColor en el componente SmallTopAppBar.*/
                titleContentColor = MaterialTheme.colorScheme.onBackground,

                /*Establece el color del contenido del icono de navegación de la barra de aplicación utilizando la propiedad navigationIconContentColor en el componente SmallTopAppBar.*/
                navigationIconContentColor = MaterialTheme.colorScheme.onBackground
            ),
            /*aplica un modificador de diseño (Modifier.padding) al componente SmallTopAppBar para agregar un relleno horizontal.*/
            modifier = Modifier.padding(horizontal = padding16dp)
        )
    }) { contentPadding -> content.invoke(contentPadding) }
}