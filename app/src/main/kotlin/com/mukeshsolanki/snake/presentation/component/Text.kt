package com.mukeshsolanki.snake.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
/*La función DisplayLarge simplifica la creación de un componente de texto grande en Jetpack Compose,
permitiendo especificar el texto, los modificadores y la alineación horizontal de manera conveniente.*/
fun DisplayLarge(
    /*modifier: Modifier = Modifier: Es un parámetro opcional que permite aplicar modificadores personalizados
    al componente de texto. Por defecto, se utiliza el modificador Modifier vacío si no se proporciona ningún modificador adicional.*/
    modifier: Modifier = Modifier,

    /*text: String: Es el texto que se mostrará en el componente de texto.*/
    text: String,

    /*textAlign: TextAlign = TextAlign.Start: Es un parámetro opcional que permite especificar la alineación horizontal del texto.
    Por defecto, se utiliza la alineación TextAlign.Start, lo que alinea el texto a la izquierda.*/
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        /*modifier = modifier: Aplica el modificador proporcionado al componente de texto. Esto permite personalizar
        la apariencia o el comportamiento del texto mediante modificadores como padding, background, etc.*/
        modifier = modifier,
        /*text = text: Establece el texto que se mostrará en el componente de texto.*/

        text = text,
        /*color = MaterialTheme.colorScheme.primary: Define el color del texto. Utiliza el esquema de colores
        primarios (primary) definido en el tema de Material Design actual (MaterialTheme).*/
        color = MaterialTheme.colorScheme.primary,

        /*style = MaterialTheme.typography.displayLarge: Define el estilo del texto. Utiliza el estilo de tipografía
        displayLarge definido en el tema de Material Design actual (MaterialTheme), que generalmente se usa para
        títulos grandes y destacados.*/
        style = MaterialTheme.typography.displayLarge,

        /*textAlign = textAlign: Establece la alineación horizontal del texto según el valor
        proporcionado en el parámetro textAlign.*/
        textAlign = textAlign
    )
}

@Composable
/*La función TitleLarge simplifica la creación de un componente de texto grande para un título en Jetpack Compose,
permitiendo especificar el texto, los modificadores y la alineación horizontal de manera conveniente.*/
fun TitleLarge(
    /*modifier: Modifier = Modifier: Es un parámetro opcional que permite aplicar modificadores personalizados al componente
    de texto. Por defecto, se utiliza el modificador Modifier vacío si no se proporciona ningún modificador adicional.*/
    modifier: Modifier = Modifier,

    /*text: String: Es el texto del título que se mostrará en el componente de texto.*/
    text: String,

    /*textAlign: TextAlign = TextAlign.Start: Es un parámetro opcional que permite especificar la alineación horizontal del texto.
    Por defecto, se utiliza la alineación TextAlign.Start, lo que alinea el texto del título a la izquierda.*/
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        /*modifier = modifier: Aplica el modificador proporcionado al componente de texto. Esto permite personalizar
        la apariencia o el comportamiento del texto mediante modificadores como padding, background, etc.*/

        modifier = modifier,
        /*text = text: Establece el texto del título que se mostrará en el componente de texto.*/
        text = text,

        /*color = MaterialTheme.colorScheme.primary: Define el color del texto del título. Utiliza el esquema de
        colores primarios (primary) definido en el tema de Material Design actual (MaterialTheme).*/
        color = MaterialTheme.colorScheme.primary,

        /*style = MaterialTheme.typography.titleLarge: Define el estilo del texto del título. Utiliza el estilo
        de tipografía titleLarge definido en el tema de Material Design actual (MaterialTheme), que generalmente
        se usa para títulos grandes y llamativos.*/
        style = MaterialTheme.typography.titleLarge,

        /*textAlign = textAlign: Establece la alineación horizontal del texto del título según el valor
        proporcionado en el parámetro textAlign.*/
        textAlign = textAlign
    )
}

@Composable
/*La función BodyLarge simplifica la creación de un componente de texto grande para el cuerpo de texto en
Jetpack Compose, permitiendo especificar el texto, los modificadores y la alineación horizontal de manera conveniente.*/
fun BodyLarge(modifier: Modifier = Modifier, text: String, textAlign: TextAlign = TextAlign.Start) {
    Text(
        /*modifier = modifier: Aplica el modificador proporcionado al componente de texto. Esto permite personalizar
        la apariencia o el comportamiento del texto mediante modificadores como padding, background, etc.*/
        modifier = modifier,

        /*text = text: Establece el texto del cuerpo de texto que se mostrará en el componente de texto.*/
        text = text,

        /*color = MaterialTheme.colorScheme.primary: Define el color del texto del cuerpo de texto. Utiliza el
        esquema de colores primarios (primary) definido en el tema de Material Design actual (MaterialTheme).*/
        color = MaterialTheme.colorScheme.primary,

        /*style = MaterialTheme.typography.bodyLarge: Define el estilo del texto del cuerpo de texto.
        Utiliza el estilo de tipografía bodyLarge definido en el tema de Material Design actual (MaterialTheme),
        que generalmente se usa para el texto del cuerpo más grande.*/
        style = MaterialTheme.typography.bodyLarge,

        /*textAlign = textAlign: Establece la alineación horizontal del texto del cuerpo de texto según
        el valor proporcionado en el parámetro textAlign.*/
        textAlign = textAlign
    )
}