package com.sdamashchuk.cocktaildetails.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.sdamashchuk.cocktaildetails.viewmodel.CocktailDetailsViewModel
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CocktailDetailsScreen() {
    val cocktailDetailsViewModel = getViewModel<CocktailDetailsViewModel>()
    val state = cocktailDetailsViewModel.collectAsState()

    cocktailDetailsViewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is CocktailDetailsViewModel.SideEffect.ShowError -> {}
        }
    }

    CocktailDetailsScreen(
        state = state
    )
}

@Composable
private fun CocktailDetailsScreen(
    state: State<CocktailDetailsViewModel.State>,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = state.value.title,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
    }
}