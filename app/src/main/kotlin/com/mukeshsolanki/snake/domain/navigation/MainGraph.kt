package com.mukeshsolanki.snake.domain.navigation

/*El código define una clase sellada (sealed class) llamada Screen, que representa
las diferentes pantallas de una aplicación. Cada instancia de la clase sellada Screen
es un objeto único y concreto que tiene una propiedad route que especifica la ruta o identificador de la pantalla.
 */
sealed class Screen(val route: String) {
    /*Menu es uno de los posibles destinos de navegación en una aplicación y su ruta asociada es "menu_screen".*/
    object Menu : Screen(route = "menu_screen")

    /*HighScores es uno de los posibles destinos de navegación en una aplicación y su ruta asociada es "high_scores_screen".*/
    object HighScores : Screen(route = "high_scores_screen")

    /*Settings es uno de los posibles destinos de navegación en una aplicación y su ruta asociada es "settings_screen".*/
    object Settings : Screen(route = "settings_screen")

    /*About es uno de los posibles destinos de navegación en una aplicación y su ruta asociada es "about_screen".*/
    object About : Screen(route = "about_screen")
}
