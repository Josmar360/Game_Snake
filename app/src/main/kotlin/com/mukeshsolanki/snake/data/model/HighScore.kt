package com.mukeshsolanki.snake.data.model

/*"Nombre_Jugador": es una propiedad de tipo String que representa el nombre del jugador asociado con la puntuación alta.
"Puntuacion": es una propiedad de tipo Int que representa la puntuación alcanzada por el jugador.*/
/*Al declarar la clase de datos con la palabra clave "data class", Kotlin automáticamente genera varios métodos útiles,
como métodos para obtener y establecer los valores de las propiedades, métodos para comparar objetos de la clase y métodos
para representar el objeto como una cadena de texto, entre otros.*/
data class PuntuacionAlta(val Nombre_Jugador: String, val Puntuacion: Int)
