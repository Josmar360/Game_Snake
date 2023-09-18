package com.mukeshsolanki.snake.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.mukeshsolanki.snake.presentation.theme.corner4dp
import com.mukeshsolanki.snake.presentation.theme.size64dp

@Composable
/*La función AppButton crea un botón personalizado utilizando el componente Button de Jetpack Compose.
Puedes especificar modificadores adicionales, el texto a mostrar y una función de retorno de llamada para
controlar el evento de clic del botón.*/
fun AppButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        /*onClick: Se establece la función de retorno de llamada onClick como el controlador de eventos para el clic del botón.*/
        onClick = onClick,

        /*modifier: Se establece el modificador proporcionado en el parámetro modifier para aplicar modificadores adicionales al botón.*/
        modifier = modifier,

        /*colors: Se establece el esquema de colores del botón utilizando el método ButtonDefaults.buttonColors. En este caso,
         se establece el containerColor en MaterialTheme.colorScheme.onBackground, lo que indica el color de fondo del botón,
         y el contentColor en MaterialTheme.colorScheme.onPrimary, lo que indica el color del texto del botón.*/
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
    /*Text(text = text): Se utiliza el componente Text para renderizar el texto del botón. El valor del parámetro text
     se muestra en el botón.*/
    { Text(text = text) }
}

@Composable
/*La función AppIconButton crea un botón de icono personalizado utilizando el componente IconButton de Jetpack Compose.*/
fun AppIconButton(modifier: Modifier = Modifier, icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        /*onClick: Se establece la función de retorno de llamada onClick como el controlador de eventos para el clic del botón de icono.*/
        onClick = onClick,
        /*modifier: Se establece el modificador proporcionado en el parámetro modifier para aplicar modificadores adicionales
        al botón de icono. En este caso, se utiliza el modificador size para establecer un tamaño de 64dp al botón de icono y
        el modificador background para establecer un color de fondo y una forma al botón de icono. El color de fondo se
        establece en MaterialTheme.colorScheme.onBackground, que representa el color de fondo del botón, y la forma se
        establece en RoundedCornerShape(corner4dp), que representa las esquinas redondeadas del botón con un radio de 4dp.*/
        modifier = modifier
            .size(size64dp)
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(corner4dp)
            ),
    ) {
        /*El código crea un componente Icon que muestra un ícono vectorial.*/
        Icon(
            /*imageVector: Es el parámetro que especifica el vector de imagen que se utilizará como el ícono. En el código que
            has proporcionado, se le asigna el valor del parámetro icon, que representa el vector de imagen proporcionado en
            la función AppIconButton.*/
            imageVector = icon,

            /*contentDescription: Es el texto descriptivo que se utiliza para proporcionar una descripción accesible del ícono
            para las personas con discapacidad visual. En el código que has proporcionado, se establece en null, lo que indica
            que no se proporciona ninguna descripción accesible para el ícono.*/
            contentDescription = null,

            /*tint: Es el color que se aplicará al ícono. En el código que has proporcionado, se establece en MaterialTheme.colorScheme.onPrimary,
            que representa el color primario definido en el esquema de colores de la aplicación. Esto asegura que el ícono se
            muestre con el color adecuado según el tema de la aplicación.*/
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}