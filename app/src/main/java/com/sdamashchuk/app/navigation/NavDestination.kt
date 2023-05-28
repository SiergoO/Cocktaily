package com.sdamashchuk.app.navigation

sealed class NavDestination(open val destination: String) {
    object CocktailList : NavDestination("destination_cocktail_list_screen")
    object CocktailDetails : NavDestination("destination_cocktail_details_screen")
}
