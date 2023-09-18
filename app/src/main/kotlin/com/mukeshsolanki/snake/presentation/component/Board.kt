package com.mukeshsolanki.snake.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mukeshsolanki.snake.data.model.State
import com.mukeshsolanki.snake.domain.game.GameEngine
import com.mukeshsolanki.snake.presentation.theme.DarkGreen
import com.mukeshsolanki.snake.presentation.theme.border2dp
import com.mukeshsolanki.snake.presentation.theme.corner4dp
import com.mukeshsolanki.snake.presentation.theme.padding16dp

@Composable
/*La función Board se encarga de dibujar el tablero de juego de Snake, incluyendo el borde del tablero,
la comida y la serpiente. Utiliza componentes Box con modificadores para definir el tamaño, la posición y
la apariencia de cada elemento en el tablero.*/
fun Board(state: State) {
    /*El componente BoxWithConstraints de Jetpack Compose para crear un contenedor con restricciones de tamaño y
    aplica un relleno de 16 unidades de densidad independiente de píxeles (dp) en todos los lados del contenedor
    utilizando el modificador padding.*/
    BoxWithConstraints(Modifier.padding(padding16dp)) {
        /*Esta línea de código calcula el tamaño de cada celda en el tablero del juego de Snake dividiendo el ancho
        máximo disponible (maxWidth) entre el tamaño del tablero (GameEngine.TAMANO_TABLERO).*/
        val tileSize = maxWidth / GameEngine.TAMANO_TABLERO

        /*Este código crea un componente Box que representa el borde del tablero de juego en el juego de Snake.
        El Box tiene un tamaño igual al ancho máximo disponible y se le aplica un borde con un ancho y color específicos.*/
        Box(
            Modifier
                .size(maxWidth)
                .border(border2dp, DarkGreen)
        )

        /*este código crea un componente Box que representa la comida en el tablero de juego de Snake. El componente Box se
        coloca en una posición específica en el tablero, se le da un tamaño adecuado y se le asigna un color de fondo y una
        forma específicos.*/
        Box(
            Modifier
                .offset(x = tileSize * state.Comida.first, y = tileSize * state.Comida.second)
                .size(tileSize)
                .background(
                    DarkGreen, CircleShape
                )
        )

        /*este código crea un componente Box para cada segmento de la serpiente en el tablero de juego de Snake. Cada segmento
        se coloca en una posición específica en el tablero, se le da un tamaño adecuado y se le asigna un color de fondo y una
        forma específicos. Esto permite representar visualmente la serpiente en el tablero de juego.*/
        state.Snake.forEach {
            Box(
                modifier = Modifier
                    .offset(x = tileSize * it.first, y = tileSize * it.second)
                    .size(tileSize)
                    .background(
                        DarkGreen, RoundedCornerShape(corner4dp)
                    )
            )
        }
    }
}