package com.sdamashchuk.app.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
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
    topBarVisibilityState: MutableState<Boolean>,
    navigationIconVisibilityState: MutableState<Boolean>
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {
            onCocktailListScreen(navController, screenTitle, topBarVisibilityState, navigationIconVisibilityState)
            onCocktailDetailsScreen(navController, screenTitle, topBarVisibilityState, navigationIconVisibilityState)
        }
    )
}

private fun NavGraphBuilder.onCocktailListScreen(
    navController: NavController,
    screenTitle: MutableState<String>,
    topAppBarVisibilityState: MutableState<Boolean>,
    navigationIconVisibility: MutableState<Boolean>
) {
    composable(
        route = NavDestination.CocktailList.destination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        screenTitle.value = stringResource(id = R.string.cocktail_list_screen_title)
        topAppBarVisibilityState.value = true
        navigationIconVisibility.value = false
        CocktailListScreen {
            navController.navigate(NavDestination.CocktailDetails.destination)
        }
    }
}

private fun NavGraphBuilder.onCocktailDetailsScreen(
    navController: NavController,
    screenTitle: MutableState<String>,
    topAppBarVisibilityState: MutableState<Boolean>,
    navigationIconVisibility: MutableState<Boolean>
) {
    composable(
        route = NavDestination.CocktailDetails.destination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        screenTitle.value = stringResource(id = R.string.cocktail_details_screen_title)
        topAppBarVisibilityState.value = false
        navigationIconVisibility.value = false
        CocktailDetailsScreen()
    }
}
