package com.sdamashchuk.app.navigation

import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.sdamashchuk.R
import com.sdamashchuk.cocktaildetails.ui.CocktailDetailsScreen
import com.sdamashchuk.cocktaillist.ui.CocktailListScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String,
    screenTitle: MutableState<String>,
    navigationIconVisibilityState: MutableState<Boolean>
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {
            onCocktailListScreen(navController, screenTitle, navigationIconVisibilityState)
            onCocktailDetailsScreen(navController, screenTitle, navigationIconVisibilityState)
        }
    )
}

private fun NavGraphBuilder.onCocktailListScreen(
    navController: NavController,
    screenTitle: MutableState<String>,
    navigationIconVisibility: MutableState<Boolean>
) {
    composable(
        route = NavDestination.CocktailList.destination,
        enterTransition = { fadeIn() },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { fadeIn() },
        popExitTransition = { ExitTransition.None }
    ) {
        screenTitle.value = stringResource(id = R.string.cocktail_list_screen_title)
        navigationIconVisibility.value = false
        CocktailListScreen { cocktailId ->
            navController.navigate("${NavDestination.CocktailDetails.destination}/${cocktailId}")
        }
    }
}

private fun NavGraphBuilder.onCocktailDetailsScreen(
    navController: NavController,
    screenTitle: MutableState<String>,
    navigationIconVisibility: MutableState<Boolean>
) {
    composable(
        route = "${NavDestination.CocktailDetails.destination}/{cocktailId}",
        arguments = listOf(navArgument("cocktailId") { type = NavType.IntType }),
        enterTransition = { fadeIn() },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { fadeIn() },
        popExitTransition = { ExitTransition.None    }
    ) {
        screenTitle.value = stringResource(id = R.string.cocktail_details_screen_title)
        navigationIconVisibility.value = true
        CocktailDetailsScreen()
    }
}
