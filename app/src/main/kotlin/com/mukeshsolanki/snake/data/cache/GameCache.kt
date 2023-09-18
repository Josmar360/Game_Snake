package com.mukeshsolanki.snake.data.cache

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.data.model.PuntuacionAlta
import com.mukeshsolanki.snake.domain.base.BASEDATOS_KEY_PUNTUACION_ALTA
import com.mukeshsolanki.snake.domain.base.BASEDATOS_KEY_NOMBRE_JUGADOR
import com.mukeshsolanki.snake.domain.base.BASEDATOS_NOMBRE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameCache(private val context: Context) {
    /*El código define una forma de acceder y manipular una base de datos utilizando la clase DataStore<Preferences>.
    También proporciona claves específicas para acceder a valores dentro de la base de datos, como la puntuación alta
    y el nombre del jugador.*/
    companion object {
        private val Context.basedatos: DataStore<Preferences> by preferencesDataStore(BASEDATOS_NOMBRE)
        val PUNTUACION_ALTA_KEY = stringPreferencesKey(BASEDATOS_KEY_PUNTUACION_ALTA)
        val NOMBRE_JUGADOR_KEY = stringPreferencesKey(BASEDATOS_KEY_NOMBRE_JUGADOR)
    }

    /*El código crea un Flow que emite una lista de puntuaciones altas obtenidas de la base de datos.
    Los datos se recuperan de la base de datos, se deserializan utilizando Gson y se emiten a través del Flow.*/
    val getAltaPuntuacion: Flow<List<PuntuacionAlta>> = context.basedatos.data.map { preferences ->
        val scores = preferences[PUNTUACION_ALTA_KEY]
        val listType = object : TypeToken<List<PuntuacionAlta?>?>() {}.type
        Gson().fromJson<List<PuntuacionAlta>>(scores, listType) ?: listOf()
    }

    /*El código crea un Flow que emite un nombre de jugador obtenido de la base de datos. Si el nombre de jugador
    no está presente en la base de datos, se utiliza un nombre de jugador predeterminado. Los datos se recuperan de
    la base de datos y se emiten a través del Flow.*/
    val getNombreJugador: Flow<String> = context.basedatos.data.map { preferences ->
        preferences[NOMBRE_JUGADOR_KEY] ?: context.getString(R.string.Nombre_Jugador_Defecto)
    }

    /*La función saveScoreAlto guarda una lista de puntuaciones altas en la base de datos. Los datos se serializan
    utilizando Gson y se almacenan en los datos asociados con la clave PUNTUACION_ALTA_KEY en la base de dato*/
    suspend fun saveScoreAlto(highScores: List<PuntuacionAlta>) {
        context.basedatos.edit { preferences ->
            preferences[PUNTUACION_ALTA_KEY] = Gson().toJson(highScores)
        }
    }

    /*La función saveNombreJugador guarda el nombre del jugador en la base de datos. El nombre se almacena en los
    datos asociados con la clave NOMBRE_JUGADOR_KEY en la base de datos.*/
    suspend fun saveNombreJugador(name: String) {
        context.basedatos.edit { preferences ->
            preferences[NOMBRE_JUGADOR_KEY] = name
        }
    }
}