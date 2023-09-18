package com.mukeshsolanki.snake.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mukeshsolanki.snake.domain.game.SnakeDirection
import com.mukeshsolanki.snake.presentation.theme.padding24dp
import com.mukeshsolanki.snake.presentation.theme.size64dp

@Composable
/*Define una función llamada Controller que representa un componente de control de dirección para el juego de Snake.
Este componente muestra flechas en forma de botones que permiten al usuario cambiar la dirección de la serpiente en el juego.*/
fun Controller(onDirectionChange: (Int) -> Unit) {
    /*El código define un modificador buttonSize que se puede usar para establecer un tamaño de 64dp a los elementos de la interfaz de usuario.*/
    val buttonSize = Modifier.size(size64dp)

    /*El código crea una variable llamada currentDirection que se utiliza para almacenar y mantener el estado actual de la dirección de la serpiente en el juego.*/
    val currentDirection = remember { mutableStateOf(SnakeDirection.Derecha) }
    /*El código crea una columna vertical que alinea sus elementos secundarios en el centro horizontal y agrega un espacio de relleno de 24dp alrededor de los elementos.
    Esto se utiliza para organizar y dar formato a los elementos dentro de la columna en la interfaz de usuario.*/
    Column(
        /*horizontalAlignment = Alignment.CenterHorizontally: Este parámetro establece la alineación horizontal de los elementos secundarios en el centro de la columna.
        Es decir, los elementos se colocarán en el centro horizontal de la columna.*/
        horizontalAlignment = Alignment.CenterHorizontally,

        /*modifier = Modifier.padding(padding24dp): Este parámetro establece un modificador padding en la columna.
        El modificador padding se utiliza para agregar un espacio de relleno alrededor de los elementos contenidos
        en la columna. En este caso, padding24dp representa un valor de 24dp para el espacio de relleno.*/
        modifier = Modifier.padding(padding24dp)
    ) {
        /*El código crea un botón con un ícono de flecha hacia arriba y define su comportamiento cuando se hace clic.
        Si la dirección actual de la serpiente no es "Abajo", se cambia la dirección de la serpiente a "Arriba" y se notifica
        el cambio al componente padre o a otra entidad a través de la función de retorno de llamada onDirectionChange.*/
        AppIconButton(icon = Icons.Default.KeyboardArrowUp) {
            if (currentDirection.value != SnakeDirection.Abajo) {
                /*onDirectionChange.invoke(SnakeDirection.Arriba): Invoca la función de retorno de llamada onDirectionChange y pasa SnakeDirection.Arriba
                como argumento. Esto notifica al componente padre o a otra entidad que la dirección de la serpiente ha cambiado a "Arriba".*/
                onDirectionChange.invoke(SnakeDirection.Arriba)

                /*currentDirection.value = SnakeDirection.Arriba: Actualiza el estado currentDirection con la nueva dirección
                "Arriba". Al cambiar el valor del estado, se asegura que la dirección de la serpiente refleje el cambio realizado por el usuario.*/
                currentDirection.value = SnakeDirection.Arriba
            }
        }
        /*El código crea un botón con un ícono de flecha hacia la izquierda dentro de una fila horizontal. Define su comportamiento
        cuando se hace clic: si la dirección actual de la serpiente no es "Derecha", se cambia la dirección de la serpiente a
        "Izquierda" y se notifica el cambio al componente padre o a otra entidad a través de la función de retorno de llamada
        onDirectionChange.*/
        Row {
            AppIconButton(icon = Icons.Default.KeyboardArrowLeft) {
                if (currentDirection.value != SnakeDirection.Derecha) {
                    /*onDirectionChange.invoke(SnakeDirection.Izquierda): Invoca la función de retorno de llamada onDirectionChange y pasa SnakeDirection.
                    Izquierda como argumento. Esto notifica al componente padre o a otra entidad que la dirección de la serpiente ha cambiado a "Izquierda".*/

                    onDirectionChange.invoke(SnakeDirection.Izquierda)
                    /*currentDirection.value = SnakeDirection.Izquierda: Actualiza el estado currentDirection con la nueva dirección
                    "Izquierda". Al cambiar el valor del estado, se asegura que la dirección de la serpiente refleje el cambio realizado por el usuario.*/
                    currentDirection.value = SnakeDirection.Izquierda
                }
            }
            /*El Spacer con el modificador de tamaño buttonSize se utiliza para crear un espacio vacío con un ancho y alto específicos
            en el diseño. Esto puede ayudar a establecer el espacio adecuado entre elementos adyacentes en una fila o columna, como en
            este caso donde se encuentra entre dos AppIconButton.*/
            Spacer(modifier = buttonSize)

            /*El código crea un botón con un ícono de flecha hacia la derecha dentro de una fila horizontal. Define su comportamiento
            cuando se hace clic: si la dirección actual de la serpiente no es "Izquierda", se cambia la dirección de la serpiente a
            "Derecha" y se notifica el cambio al componente padre o a otra entidad a través de la función de retorno de llamada onDirectionChange.*/
            AppIconButton(icon = Icons.Default.KeyboardArrowRight) {
                if (currentDirection.value != SnakeDirection.Izquierda) {
                    /*onDirectionChange.invoke(SnakeDirection.Derecha): Invoca la función de retorno de llamada onDirectionChange y pasa
                    SnakeDirection.Derecha como argumento. Esto notifica al componente padre o a otra entidad que la dirección de la serpiente ha cambiado a "Derecha".*/
                    onDirectionChange.invoke(SnakeDirection.Derecha)

                    /*currentDirection.value = SnakeDirection.Derecha: Actualiza el estado currentDirection con la nueva dirección "Derecha".
                    Al cambiar el valor del estado, se asegura que la dirección de la serpiente refleje el cambio realizado por el usuario.*/
                    currentDirection.value = SnakeDirection.Derecha
                }
            }
        }

        /*El código crea un botón con un ícono de flecha hacia abajo dentro de una columna vertical. Define su comportamiento cuando
        se hace clic: si la dirección actual de la serpiente no es "Arriba", se cambia la dirección de la serpiente a "Abajo" y se
        notifica el cambio al componente padre o a otra entidad a través de la función de retorno de llamada onDirectionChange.*/
        AppIconButton(icon = Icons.Default.KeyboardArrowDown) {
            if (currentDirection.value != SnakeDirection.Arriba) {
                /*onDirectionChange.invoke(SnakeDirection.Abajo): Invoca la función de retorno de llamada onDirectionChange y pasa SnakeDirection.Abajo
                como argumento. Esto notifica al componente padre o a otra entidad que la dirección de la serpiente ha cambiado a "Abajo".*/
                onDirectionChange.invoke(SnakeDirection.Abajo)

                /*currentDirection.value = SnakeDirection.Abajo: Actualiza el estado currentDirection con la nueva dirección "Abajo".
                Al cambiar el valor del estado, se asegura que la dirección de la serpiente refleje el cambio realizado por el usuario.*/
                currentDirection.value = SnakeDirection.Abajo
            }
        }
    }
}