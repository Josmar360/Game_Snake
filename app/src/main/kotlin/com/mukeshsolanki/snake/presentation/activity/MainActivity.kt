package com.mukeshsolanki.snake.presentation.activity

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mukeshsolanki.snake.domain.base.BaseActivity
import com.mukeshsolanki.snake.domain.navigation.Screen
import com.mukeshsolanki.snake.presentation.screen.AboutScreen
import com.mukeshsolanki.snake.presentation.screen.HighScoreScreen
import com.mukeshsolanki.snake.presentation.screen.MenuScreen
import com.mukeshsolanki.snake.presentation.screen.SettingScreen

class MainActivity : BaseActivity() {
    /*La variable navController se utiliza para mantener una referencia al controlador de navegación de la aplicación.
    Este controlador de navegación es responsable de administrar y realizar las transiciones entre los diferentes destinos
    de la aplicación, como fragmentos, actividades o composiciones en Jetpack Compose.*/
    private lateinit var navControlador: NavHostController

    @Composable
    /*El código establece el NavController utilizando rememberNavController() y luego llama a la función SetupNavigation()
    para configurar la navegación en la aplicación. Esto sugiere que la función Content() está destinada a ser utilizada
    como punto de entrada para la configuración de la interfaz de usuario y la navegación en la aplicación basada en Jetpack
    Compose y Navigation.*/
    override fun Content() {
        /*navController = rememberNavController(): Se inicializa la variable navController utilizando la función
        rememberNavController(). Esto crea un objeto NavController que se utiliza para navegar entre diferentes
        destinos en el gráfico de navegación de la aplicación.*/
        navControlador = rememberNavController()

        /*SetupNavigation(): Se llama a la función SetupNavigation(), que se encargue de configurar
        la navegación en la aplicación. Esta función podría definir los destinos del gráfico de navegación, configurar
        los argumentos y acciones de navegación, y establecer las transiciones y animaciones de navegación.*/
        SetupNavigation()
    }

    @Composable
    /*La función SetupNavigation() configura la navegación en la aplicación utilizando NavHost y define múltiples destinos
    con sus respectivas interfaces de usuario. Cada destino se asocia a una ruta específica y se utiliza un navController
    para controlar la navegación entre ellos.*/
    private fun SetupNavigation() {
        /*NavHost: Es un componente de Jetpack Compose que actúa como un contenedor para los destinos de navegación de la
        aplicación. Se utiliza para definir y controlar la navegación entre los destinos.*/
        NavHost(navController = navControlador, startDestination = Screen.Menu.route) {
            /*composable(Screen.Menu.route) { MenuScreen(navControlador) }: Define el destino con la ruta Screen.Menu.route y
            asigna la MenuScreen como la interfaz de usuario para ese destino. Se pasa el navControlador como argumento a MenuScreen.*/
            composable(Screen.Menu.route) { MenuScreen(navControlador) }

            /*composable(Screen.HighScores.route) { HighScoreScreen(navControlador) }: Define el destino con la ruta
            Screen.HighScores.route y asigna la HighScoreScreen como la interfaz de usuario para ese destino. Se pasa el
            navControlador como argumento a HighScoreScreen*/
            composable(Screen.HighScores.route) { HighScoreScreen(navControlador) }

            /*composable(Screen.Settings.route) { SettingScreen(navControlador) }: Define el destino con la ruta
            Screen.Settings.route y asigna la SettingScreen como la interfaz de usuario para ese destino. Se pasa el
            navControlador como argumento a SettingScreen.*/
            composable(Screen.Settings.route) { SettingScreen(navControlador) }

            /*composable(Screen.About.route) { AboutScreen(navControlador) }: Define el destino con la ruta
            Screen.About.rout y asigna la AboutScreen como la interfaz de usuario para ese destino. Se pasa el navControlador
            como argumento a AboutScreen*/
            composable(Screen.About.route) { AboutScreen(navControlador) }
        }
    }
}
