package com.mukeshsolanki.snake.data.model

/*"Comida": es una propiedad de tipo Pair<Int, Int> que representa la posición de la comida en el juego.
Un par de enteros se utiliza para indicar las coordenadas (x, y) de la posición de la comida en el tablero del juego.*/
/*"Snake": es una propiedad de tipo List<Pair<Int, Int>> que representa la serpiente en el juego. La serpiente se
representa como una lista de pares de enteros que indican las coordenadas (x, y) de cada segmento del cuerpo de la serpiente.*/
/*"DireccionActual": es una propiedad de tipo Int que representa la dirección actual en la que se mueve la serpiente.
El valor de esta propiedad puede ser un número entero que indica una dirección específica, como 0 para la derecha,
1 para abajo, 2 para la izquierda y 3 para arriba, por ejemplo.*/
data class State(
    val Comida: Pair<Int, Int>,
    val Snake: List<Pair<Int, Int>>,
    val DireccionActual: Int
)