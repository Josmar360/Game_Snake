package com.mukeshsolanki.snake.presentation.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.lifecycleScope
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.data.cache.GameCache
import com.mukeshsolanki.snake.data.model.PuntuacionAlta
import com.mukeshsolanki.snake.domain.base.BaseActivity
import com.mukeshsolanki.snake.domain.base.TOP_3
import com.mukeshsolanki.snake.domain.game.GameEngine
import com.mukeshsolanki.snake.presentation.screen.EndScreen
import com.mukeshsolanki.snake.presentation.screen.GameScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class GameActivity : BaseActivity() {
    /*La variable dataStore de tipo GameCache se utiliza para almacenar una referencia
    a un objeto que proporciona un almacenamiento de datos relacionados con el juego.*/
    private lateinit var dataStore: GameCache

    /*La propiedad isPlaying se inicializa con un valor inicial de true, lo que indica
    que el juego está en curso o en estado de reproducción.*/
    private val isPlaying = mutableStateOf(true)

    /*La variable score se inicializa con un valor inicial de 0, lo que indica que el
    puntaje del juego comienza en cero.*/
    private var score = mutableStateOf(0)

    /*la variable scope de tipo CoroutineScope se utiliza para definir un ámbito de
    corutina en el que se ejecutarán y controlarán las corutinas.*/
    private lateinit var scope: CoroutineScope

    /*La variable playerName de tipo String se utiliza para almacenar el nombre
    del jugador en el juego .*/
    private lateinit var playerName: String

    /*La variable highScores almacena una lista de objetos de tipo PuntuacionAlta,
    representan los puntajes más altos o registros de puntuación en el juego.*/
    private lateinit var highScores: List<PuntuacionAlta>

    /*El código crea una instancia de GameEngine y asigna esa instancia a la variable
    gameEngine, configurando los callbacks onJuegoTerminado y onAlimentosComidos. Estos
    callbacks se ejecutarán en momentos específicos del juego (al finalizar el juego y cuando
    se coman alimentos, respectivamente) para realizar acciones como guardar los puntajes altos
    o incrementar el puntaje del juego.*/
    private var gameEngine = GameEngine(
        Alcance = lifecycleScope,
        onJuegoTerminado = {
            if (isPlaying.value) {
                isPlaying.value = false
                scope.launch { dataStore.saveScoreAlto(highScores) }
            }
        },
        onAlimentosComidos = { score.value++ }
    )

    @Composable
    /*El código define la estructura de la interfaz de usuario, recupera los datos del jugador y las puntuaciones
    altas del dataStore, y muestra diferentes pantallas dependiendo del estado del juego (isPlaying.value).*/
    override fun Content() {
        /*scope = rememberCoroutineScope(): Se inicializa la variable scope con un CoroutineScope obtenido utilizando
        la función rememberCoroutineScope(). Esto se hace para poder lanzar corutinas en este alcance y administrarlas
        adecuadamente durante el ciclo de vida del componente.*/
        scope = rememberCoroutineScope()

        /*dataStore = GameCache(applicationContext): Se inicializa la variable dataStore con una instancia de GameCache,
        que es una clase que maneja el almacenamiento de datos relacionados con el juego. Se pasa el contexto de
        la aplicación (applicationContext) para la inicialización.*/
        dataStore = GameCache(applicationContext)

        /*playerName = dataStore.getNombreJugador.collectAsState(...): Se recupera el nombre del jugador del dataStore
        utilizando collectAsState(), que es una función de Flow en Kotlin coroutines que permite recolectar el último valor
        emitido y convertirlo en un State observable. Se utiliza el valor inicial "Nombre_Jugador_Defecto" del archivo de
        recursos (stringResource()) si no hay un nombre de jugador guardado previamente.*/
        playerName =
            dataStore.getNombreJugador.collectAsState(initial = stringResource(id = R.string.Nombre_Jugador_Defecto)).value

        /*highScores = dataStore.getAltaPuntuacion.collectAsState(...): Se recuperan las puntuaciones altas del dataStore
        utilizando collectAsState(). Al igual que con playerName, se convierte el resultado en un State observable. Se
        utiliza una lista vacía como valor inicial si no hay puntuaciones altas guardadas previamente.*/
        highScores = dataStore.getAltaPuntuacion.collectAsState(initial = listOf()).value.plus(
            PuntuacionAlta(playerName, score.value)
        ).sortedByDescending { it.Puntuacion }.take(TOP_3)
        Column {
            if (isPlaying.value) {
                GameScreen(gameEngine, score.value)
            } else {
                EndScreen(score.value) {
                    score.value = 0
                    gameEngine.reset()
                    isPlaying.value = true
                }
            }
        }
    }
}