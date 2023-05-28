package com.sdamashchuk.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.sdamashchuk.app.navigation.AppNavigation
import com.sdamashchuk.app.navigation.NavDestination

@Composable
internal fun MainLauncher(
    onContainerReady: () -> Unit
) {
    val animatedNavController = rememberAnimatedNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = MaterialTheme.colorScheme.background
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentColor = MaterialTheme.colorScheme.background
        ) {
            AppNavigation(
                navController = animatedNavController,
                startDestination = NavDestination.CocktailList.destination
            )
        }
    }
    onContainerReady()
}