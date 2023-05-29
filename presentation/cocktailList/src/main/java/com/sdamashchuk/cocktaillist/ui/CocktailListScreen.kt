package com.sdamashchuk.cocktaillist.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sdamashchuk.cocktaillist.viewmodel.CocktailListViewModel
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CocktailListScreen(
    navigateToCocktailDetails: (cocktailId: Int) -> Unit
) {
    val cocktailListViewModel = getViewModel<CocktailListViewModel>()
    val state = cocktailListViewModel.collectAsState()
    val context = LocalContext.current

    cocktailListViewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is CocktailListViewModel.SideEffect.NavigateToCocktailDetails -> {
                navigateToCocktailDetails.invoke(sideEffect.cocktailId)
            }

            is CocktailListViewModel.SideEffect.ShowError -> {
                Toast.makeText(context, sideEffect.message ?: "", Toast.LENGTH_LONG).show()
            }
        }
    }

    if (!state.value.isLoading) {
        CocktailListScreen(
            state = state,
            cocktailClickedAction = { cocktailId ->
                cocktailListViewModel.sendAction(CocktailListViewModel.Action.CocktailClicked(cocktailId))
            }
        )
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
            )
        }
    }
}

@Composable
private fun CocktailListScreen(
    state: State<CocktailListViewModel.State>,
    cocktailClickedAction: (cocktailId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        items(state.value.cocktails) { cocktail ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .clickable {
                        cocktailClickedAction.invoke(cocktail.id)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(96.dp)
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 0.dp
                            )
                        ),
                    model = cocktail.imageUrl,
                    placeholder = rememberVectorPainter(Icons.Default.Image),
                    contentDescription = cocktail.name
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(start = 24.dp)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterStart),
                        text = cocktail.name,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Divider(
                        modifier = Modifier.align(Alignment.BottomStart)
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}