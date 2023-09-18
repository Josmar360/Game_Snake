package com.mukeshsolanki.snake.domain.game

/*El código que has mostrado define un objeto llamado SnakeDirection que contiene constantes
para representar las direcciones de movimiento de la serpiente en un juego de Snake.*/
object SnakeDirection {
    /*Ninguno: Representa la dirección "sin movimiento". Se utiliza cuando la
    serpiente no está en movimiento o cuando no se ha especificado una dirección.*/
    const val Ninguno = 0

    /*Derecha: Representa la dirección hacia la derecha.*/
    const val Derecha = 1

    /*Izquierda: Representa la dirección hacia la izquierda.*/
    const val Izquierda = 2

    /*Arriba: Representa la dirección hacia arriba.*/
    const val Arriba = 3

    /*Abajo: Representa la dirección hacia abajo.*/
    const val Abajo = 4
}
