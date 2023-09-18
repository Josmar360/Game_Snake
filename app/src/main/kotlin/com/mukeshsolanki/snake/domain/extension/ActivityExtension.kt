package com.mukeshsolanki.snake.domain.extension

import android.content.Context
import android.content.Intent
import android.os.Bundle

/*La función "launchActivity" permite iniciar una actividad en Android de manera más conveniente.
Toma como parámetros opcionales un objeto Bundle llamado "options" y una lambda sin nombre
(noinline) llamada "init" que acepta un objeto Intent y no devuelve nada.*/
inline fun <reified T : Any> Context.launchActivity(
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
)
/*Estas líneas de código se encargan de crear un objeto Intent, personalizarlo utilizando la
función lambda "init" y luego iniciar la actividad correspondiente utilizando el objeto
Intent y las opciones proporcionadas.*/
{
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent, options)
}

/*La función "newIntent" se utiliza para crear un objeto Intent en función del tipo de clase "T" y el contexto proporcionado.*/
inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)
