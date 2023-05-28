package com.sdamashchuk.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.sdamashchuk.cocktaillist.ui.CocktailListScreen
import com.sdamashchuk.cocktaildetails.ui.CocktailDetailsScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {
            onCocktailListScreen(navController)
            onCocktailDetailsScreen(navController)
        }
    )
}

private fun NavGraphBuilder.onCocktailListScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.CocktailList.destination
    ) {
        CocktailListScreen {
            navController.navigate(NavDestination.CocktailDetails.destination)
        }
    }
}

private fun NavGraphBuilder.onCocktailDetailsScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.CocktailDetails.destination
    ) {
        CocktailDetailsScreen()
    }
}
