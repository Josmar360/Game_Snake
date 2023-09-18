package com.mukeshsolanki.snake.presentation.screen

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.domain.game.GameEngine
import com.mukeshsolanki.snake.domain.game.SnakeDirection
import com.mukeshsolanki.snake.presentation.activity.GameActivity
import com.mukeshsolanki.snake.presentation.component.AppBar
import com.mukeshsolanki.snake.presentation.component.Board
import com.mukeshsolanki.snake.presentation.component.Controller

@Composable
/*Permite el movimiento de la serpiente en durante la partida*/
fun GameScreen(gameEngine: GameEngine, score: Int) {
    /*El código utiliza collectAsState para recopilar el estado actual del motor del juego y almacenarlo en un estado mutable en Compose llamado state. */
    val state = gameEngine.estado.collectAsState(initial = null)

    /*El código intenta obtener una referencia a una instancia de GameActivity desde el contexto local.*/
    val activity = LocalContext.current as GameActivity

    /*El código obtiene una instancia del SensorManager del sistema a través del contexto local, lo que permite acceder y utilizar los sensores del dispositivo.*/
    val sensorManager = LocalContext.current.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    /*El código utiliza la instancia de SensorManager previamente obtenida para acceder al sensor de acelerómetro predeterminado del dispositivo.*/
    val accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    /*Aquí se crea un objeto anónimo que implementa la interfaz SensorEventListener.
    Esto permite definir y sobrescribir los métodos de la interfaz en línea.*/
    val sensorListener = object : SensorEventListener {
        /*Este método se llama cuando la precisión (accuracy) de un sensor específico cambia. Sin embargo, en este caso, el
        método está vacío, es decir, no se realiza ninguna acción en respuesta a este evento.*/
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        /*El código captura los cambios en los datos del sensor de acelerómetro y utiliza
        esos valores para determinar la dirección y el movimiento de la serpiente en el juego.*/
        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                /*val x = it.values[0] y val y = it.values[1]: Se obtienen los valores de aceleración en el eje X y en el eje Y
                respectivamente. Los valores están disponibles en el campo values del evento y se acceden mediante el índice correspondiente.*/
                val x = it.values[0]
                val y = it.values[1]

                /*val direction = calculateSnakeDirection(x, y): Se llama a la función calculateSnakeDirection() para determinar la
                dirección en la que se debe mover la serpiente en base a los valores de aceleración obtenidos del sensor de acelerómetro.
                La función calculateSnakeDirection() retorna un entero que representa la dirección de movimiento.*/
                val direction = calculateSnakeDirection(x, y)

                /*gameEngine.mover = calculateMovement(direction): Se llama a la función calculateMovement() para determinar la cantidad
                de movimiento en el eje X y en el eje Y que debe realizar la serpiente. El resultado de la función calculateMovement()
                es asignado a la propiedad mover del objeto gameEngine, que probablemente controla la lógica del juego.*/
                gameEngine.mover = calculateMovement(direction)
            }
        }
    }

    /*El código registra un listener para el sensor de acelerómetro y configura la velocidad de muestreo para
    capturar los eventos del sensor a una frecuencia adecuada para juegos. El listener implementará la lógica para
    manejar los eventos del sensor de acelerómetro y realizará las acciones necesarias en función de los datos
    proporcionados por el sensor.*/
    sensorManager.registerListener(sensorListener, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME)

    /*El código muestra una barra de aplicación con un título que muestra el puntaje actual del jugador y un
    botón de retroceso. Debajo de la barra de aplicación, se crea una columna que alinea su contenido en el
    centro horizontalmente y tiene un relleno alrededor de su contenido.*/
    AppBar(
        /*title: Establece el título de la barra de aplicación utilizando el recurso de cadena con el ID
        R.string.Tu_Puntuaje y el valor de score. Esto significa que el título de la barra de aplicación será una
        cadena formateada que muestra el puntaje actual del jugador.*/
        title = stringResource(id = R.string.Tu_Puntuaje, score),

        /*onBackClicked: Especifica una acción que se ejecutará cuando se haga clic en el botón de retroceso en
        la barra de aplicación. En este caso, llama al método finish() de la actividad (activity.finish()) para
        finalizar y cerrar la actividad actual.*/
        onBackClicked = { activity.finish() }) { contentPadding ->

        /*Column: Crea una columna en la interfaz de usuario con las siguientes propiedades:*/
        Column(
            /*modifier: Define las modificaciones aplicadas a la columna. En este caso, se utiliza el modificador
            padding(contentPadding) para aplicar un relleno alrededor de la columna, utilizando el valor proporcionado por contentPadding.*/
            modifier = Modifier.padding(contentPadding),

            /*horizontalAlignment: Especifica la alineación horizontal del contenido de la columna. Alignment.CenterHorizontally
            indica que el contenido se alineará en el centro horizontal de la columna.*/
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.value?.let { Board(it) }
            /*Botones en pantalla del juego */
           /* Controller {
                when (it) {
                    SnakeDirection.Abajo -> gameEngine.mover = Pair(0, -1)
                    SnakeDirection.Izquierda -> gameEngine.mover = Pair(1, 0)
                    SnakeDirection.Derecha -> gameEngine.mover = Pair(-1, 0)
                    SnakeDirection.Arriba -> gameEngine.mover = Pair(0, 1)
                }
            }*/
        }
    }
}

/*El código que muestras es una función llamada calculateSnakeDirection() que toma dos valores de tipo Float,
x e y, que representan las lecturas de aceleración en los ejes x e y, respectivamente. La función devuelve un
valor entero que representa la dirección de la serpiente en el juego.*/
private fun calculateSnakeDirection(x: Float, y: Float): Int {
    /*La función utiliza una estructura de control when para evaluar las diferentes condiciones basadas en los
    valores de x e y y determinar la dirección de la serpiente. Aquí está la lógica utilizada en cada caso:*/
    return when {
        /*Si x es mayor que 1.5f, la función devuelve SnakeDirection.Derecha, lo que indica que la serpiente debe moverse hacia la derecha.*/
        x > 1.5f -> SnakeDirection.Derecha

        /*Si x es menor que -1.5f, la función devuelve SnakeDirection.Izquierda, indicando que la serpiente debe moverse hacia la izquierda.*/
        x < -1.5f -> SnakeDirection.Izquierda

        /*Si y es mayor que 1.5f, la función devuelve SnakeDirection.Abajo, lo que indica que la serpiente debe moverse hacia abajo.*/
        y > 1.5f -> SnakeDirection.Abajo

        /*Si y es menor que -0.1f, la función devuelve SnakeDirection.Arriba, indicando que la serpiente debe moverse hacia arriba.*/
        y < -0.1f -> SnakeDirection.Arriba

        /*En cualquier otro caso, la función devuelve SnakeDirection.Ninguno, lo que indica que no se debe realizar ningún movimiento de la serpiente.*/
        else -> SnakeDirection.Ninguno
    }
}

/*Esta función se utiliza para calcular los cambios en las coordenadas x e y que la serpiente debe realizar en función de la dirección de movimiento especificada.
Estos cambios se utilizan posteriormente para actualizar la posición de la serpiente en el juego.*/
private fun calculateMovement(direction: Int): Pair<Int, Int> {
    /*La función utiliza una estructura de control when para evaluar el valor de direction y determinar los cambios en las coordenadas x e y correspondientes
    a la dirección de movimiento de la serpiente. Aquí está la lógica utilizada en cada caso:*/
    return when (direction) {
        /*Si direction es igual a SnakeDirection.Arriba, la función devuelve el par de valores (0, -1), lo que indica que la serpiente debe moverse hacia arriba en las coordenadas y.*/
        SnakeDirection.Arriba -> Pair(0, -1)

        /*Si direction es igual a SnakeDirection.Izquierda, la función devuelve el par de valores (1, 0), indicando que la serpiente debe moverse hacia la izquierda en las coordenadas x.*/
        SnakeDirection.Izquierda -> Pair(1, 0)

        /*Si direction es igual a SnakeDirection.Derecha, la función devuelve el par de valores (-1, 0), indicando que la serpiente debe moverse hacia la derecha en las coordenadas x.*/
        SnakeDirection.Derecha -> Pair(-1, 0)

        /*Si direction es igual a SnakeDirection.Abajo, la función devuelve el par de valores (0, 1), indicando que la serpiente debe moverse hacia abajo en las coordenadas y.*/
        SnakeDirection.Abajo -> Pair(0, 1)

        /*En cualquier otro caso, la función devuelve el par de valores por defecto (1, 0), indicando que la serpiente debe moverse hacia la derecha en las coordenadas x.*/
        else -> Pair(1, 0)
    }
}
