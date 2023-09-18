package com.mukeshsolanki.snake.domain.game

import androidx.compose.runtime.mutableStateOf
import com.mukeshsolanki.snake.data.model.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.*

class GameEngine(
    /*Al declarar la propiedad Alcance como CoroutineScope, se está creando un alcance de corutina que puede ser
    utilizado para lanzar y controlar corutinas en el contexto de esa instancia de clase. */
    private val Alcance: CoroutineScope,

    /*Este patrón se utiliza comúnmente para permitir que el código externo registre una acción personalizada
    que se ejecutará cuando ocurra un evento específico, como el final del juego.*/
    private val onJuegoTerminado: () -> Unit,

    /*la propiedad "onAlimentosComidos" almacena una referencia a una función sin argumentos y sin valor
    de retorno que se ejecutará en un momento determinado cuando se cumpla una condición o evento específico
    relacionado con la comida en el juego.*/
    private val onAlimentosComidos: () -> Unit
) {
    /*La propiedad "mutex" se utiliza como mecanismo de bloqueo para garantizar la exclusión mutua y prevenir
    condiciones de carrera en secciones críticas de código que podrían ser ejecutadas concurrentemente por
    varios hilos o coroutines.*/
    private val mutex = Mutex()

    /*El código establece una propiedad privada "mutableState" utilizando "MutableStateFlow" para almacenar
    y emitir el estado mutable de alguna entidad en el juego o aplicación.
    El estado se inicializa con valores específicos y se puede actualizar a medida que cambia.*/
    private val mutableState =
        MutableStateFlow(
            State(
                Comida = Pair(5, 5),
                Snake = listOf(Pair(7, 7)),
                DireccionActual = SnakeDirection.Derecha
            )
        )

    /*El código establece una variable inmutable "estado" que contiene un flujo de objetos "State".
    Esto permite la emisión y observación de cambios en el estado de alguna entidad dentro de un juego o aplicación.*/
    val estado: Flow<State> = mutableState

    /*El código muestra una propiedad privada llamada "direccionActual" que utiliza la función
    "mutableStateOf" para inicializar su valor con "SnakeDirection.Derecha".*/
    private val direccionActual = mutableStateOf(SnakeDirection.Derecha)

    /*el código define una variable "mover" que representa el vector de movimiento de la serpiente
    en un juego de serpiente. El setter personalizado garantiza que la actualización de la variable
    "mover" se realice de forma segura en un entorno concurrente utilizando un bloqueo y un coroutine.*/
    var mover = Pair(1, 0)
        set(value) {
            Alcance.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    /*a función "reset" se encarga de restablecer o reiniciar el estado de un juego de serpiente,
    configurando nuevas posiciones para la comida y la serpiente, estableciendo una nueva dirección
    de movimiento y actualizando las variables relacionadas con el movimiento de la serpiente.*/
    fun reset() {
        mutableState.update {
            it.copy(
                Comida = Pair(5, 5),
                Snake =  listOf(Pair(7, 7)),
                DireccionActual = SnakeDirection.Derecha
            )
        }
        direccionActual.value = SnakeDirection.Derecha
        mover = Pair(1, 0)
    }

    init {
        Alcance.launch {
            var snakeLength = 2
            while (true) {
                delay(150)
                mutableState.update {
                    //Verifica si la serpiente ha alcanzado el límite izquierdo del área de juego en función de su dirección actual
                    val hasReachedLeftEnd =
                        it.Snake.first().first == 0 && it.DireccionActual == SnakeDirection.Izquierda

                    //Verifica si la serpiente ha alcanzado el límite superior del área de juego en función de su dirección actual
                    val hasReachedTopEnd =
                        it.Snake.first().second == 0 && it.DireccionActual == SnakeDirection.Arriba

                    //Verifica si la serpiente ha alcanzado el límite derecho del área de juego en función de su dirección actual
                    val hasReachedRightEnd =
                        it.Snake.first().first == TAMANO_TABLERO - 1 && it.DireccionActual == SnakeDirection.Derecha

                    //Verifica si la serpiente ha alcanzado el límite inferior del área de juego en función de su dirección actual
                    val hasReachedBottomEnd =
                        it.Snake.first().second == TAMANO_TABLERO - 1 && it.DireccionActual == SnakeDirection.Abajo

                    //Verifica si la serpiente ha alcanzado alguno de los límites del área de juego
                    /*if (hasReachedLeftEnd || hasReachedTopEnd || hasReachedRightEnd || hasReachedBottomEnd) {
                        snakeLength = 2
                        onJuegoTerminado.invoke()
                    }*/

                    //Establece la dirección actual de movimiento de la serpiente en función de las coordenadas de movimiento
                    /*if (mover.first == 0 && mover.second == -1) {
                        direccionActual.value = SnakeDirection.Arriba
                    } else if (mover.first == -1 && mover.second == 0) {
                        direccionActual.value = SnakeDirection.Izquierda
                    } else if (mover.first == 1 && mover.second == 0) {
                        direccionActual.value = SnakeDirection.Derecha
                    } else if (mover.first == 0 && mover.second == 1) {
                        direccionActual.value = SnakeDirection.Abajo
                    }*/

                    //Calcula la nueva posición de la cabeza de la serpiente en base a su posición actual y las coordenadas de movimiento
                    val newPosition = it.Snake.first().let { poz ->
                        mutex.withLock {
                            Pair(
                                (poz.first + mover.first + TAMANO_TABLERO) % TAMANO_TABLERO,
                                (poz.second + mover.second + TAMANO_TABLERO) % TAMANO_TABLERO
                            )
                        }
                    }

                    //Verificar si la nueva posición de la cabeza de la serpiente coincide con la posición de la comida
                    if (newPosition == it.Comida) {
                        onAlimentosComidos.invoke()
                        snakeLength++
                    }

                    //Se verifica si la serpiente no ha chocado con alguna parte de su cuerpo
                    if (it.Snake.contains(newPosition)) {
                        snakeLength = 2
                        onJuegoTerminado.invoke()
                    }

                    //La posición de la comida se actualiza si la serpiente ha alcanzado la posición de la comida
                    it.copy(
                        Comida = if (newPosition == it.Comida) Pair(
                            Random().nextInt(TAMANO_TABLERO),
                            Random().nextInt(TAMANO_TABLERO)
                        ) else it.Comida,
                        Snake = listOf(newPosition) + it.Snake.take(snakeLength - 1),
                        DireccionActual = direccionActual.value,
                    )
                }
            }
        }
    }

    //Valor constante del tamaño del tablero
    companion object {
        const val TAMANO_TABLERO = 32
    }
}
