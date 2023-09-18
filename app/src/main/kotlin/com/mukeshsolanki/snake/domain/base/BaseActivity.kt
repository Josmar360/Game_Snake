package com.mukeshsolanki.snake.domain.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mukeshsolanki.snake.presentation.theme.SnakeTheme

abstract class BaseActivity : ComponentActivity() {

    /*Este código establece el tema de la interfaz de usuario, crea una superficie con un color de
    fondo y define el contenido de la actividad utilizando Jetpack Compose.*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnakeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { Content() }
            }
        }
    }

    @Composable
    /*La función "Content()" se declara como abstracta, lo que implica que cualquier clase o interfaz
    que herede o implemente la clase que contiene esta función debe proporcionar su propia implementación
    de la función "Content()".*/
    abstract fun Content()
}