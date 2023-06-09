package com.sdamashchuk.app

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.sdamashchuk.app.navigation.AppNavigation
import com.sdamashchuk.app.navigation.NavDestination
import com.sdamashchuk.common.compose.component.TopBar

@Composable
internal fun MainContainer(
    onContainerReady: () -> Unit
) {
    val animatedNavController = rememberAnimatedNavController()
    val navigationIconVisibilityState = rememberSaveable { (mutableStateOf(false)) }
    val screenTitle = rememberSaveable { (mutableStateOf("")) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = screenTitle.value,
                isNavigationIconVisible = navigationIconVisibilityState.value,
                onBackPressed = { animatedNavController.navigateUp() }
            )
        },
        contentColor = MaterialTheme.colorScheme.background
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .padding(it),
            contentColor = MaterialTheme.colorScheme.background
        ) {
            AppNavigation(
                navController = animatedNavController,
                startDestination = NavDestination.CocktailList.destination,
                screenTitle,
                navigationIconVisibilityState
            )
        }
    }
    onContainerReady()
}