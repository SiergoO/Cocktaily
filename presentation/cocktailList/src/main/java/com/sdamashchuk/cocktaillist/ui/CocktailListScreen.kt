package com.sdamashchuk.cocktaillist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sdamashchuk.cocktaillist.viewmodel.CocktailListViewModel
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CocktailListScreen(
    navigateToCocktailDetails: () -> Unit
) {
    val cocktailListViewModel = getViewModel<CocktailListViewModel>()
    val state = cocktailListViewModel.collectAsState()

    cocktailListViewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            CocktailListViewModel.SideEffect.NavigateToCocktailDetails -> navigateToCocktailDetails.invoke()
            is CocktailListViewModel.SideEffect.ShowError -> {}
        }
    }

    CocktailListScreen(
        state = state,
        cocktailClickedAction = navigateToCocktailDetails
    )
}

@Composable
private fun CocktailListScreen(
    state: State<CocktailListViewModel.State>,
    cocktailClickedAction: () -> Unit
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
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = cocktailClickedAction
        ) {
            Text(
                text = "Go to cocktail details",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}