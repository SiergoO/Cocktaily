package com.sdamashchuk.cocktaildetails.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sdamashchuk.cocktaildetails.viewmodel.CocktailDetailsViewModel
import com.sdamashchuk.common.compose.component.Header
import com.sdamashchuk.common.compose.component.VerticalDivider
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CocktailDetailsScreen() {
    val cocktailDetailsViewModel = getViewModel<CocktailDetailsViewModel>()
    val state = cocktailDetailsViewModel.collectAsState()
    val context = LocalContext.current

    cocktailDetailsViewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is CocktailDetailsViewModel.SideEffect.ShowError -> {
                Toast.makeText(context, sideEffect.message ?: "", Toast.LENGTH_LONG).show()
            }
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
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 24.dp,
                end = 24.dp,
                bottom = 24.dp
            )
            .verticalScroll(scrollState)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 0.dp,
                        bottomEnd = 32.dp,
                        bottomStart = 32.dp
                    )
                ),
            model = state.value.cocktailDetails.imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = state.value.cocktailDetails.name
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(horizontal = 16.dp)
        ) {
            VerticalDivider(
                thickness = 4.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = state.value.cocktailDetails.name,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = state.value.cocktailDetails.category.orEmpty(),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        if (state.value.cocktailDetails.creativeCommonsConfirmed == true) {
            InfoRow(
                icon = Icons.Default.VerifiedUser,
                contentDescription = "Creative Commons Confirmed",
                text = "Creative Commons Confirmed"
            )
        }
        if (!state.value.cocktailDetails.strGlass.isNullOrEmpty())
            InfoRow(
                icon = Icons.Default.LocalBar,
                contentDescription = "Glass Type",
                text = state.value.cocktailDetails.strGlass!!
            )
        if (!state.value.cocktailDetails.alcoholic.isNullOrEmpty())
            InfoRow(
                icon = Icons.Default.AutoAwesome,
                contentDescription = "Alcoholic",
                text = state.value.cocktailDetails.alcoholic!!
            )
        Spacer(modifier = Modifier.height(24.dp))
        Header(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Instruction"
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = state.value.cocktailDetails.instruction.orEmpty(),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(24.dp))
        Header(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Ingridients"
        )
        Spacer(modifier = Modifier.height(12.dp))
        state.value.cocktailDetails.ingredients.keys.toList().forEach { ingridient ->
            val stepIndex = state.value.cocktailDetails.ingredients.keys.indexOf(ingridient)
            val measure = state.value.cocktailDetails.ingredients[ingridient]
            val isLastStep = state.value.cocktailDetails.ingredients.size == stepIndex + 1
            Ingredient(
                ingredientText = ingridient.orEmpty(),
                measureText = measure.orEmpty(),
                stepNumber = stepIndex + 1,
                isFirstStep = stepIndex == 0,
                isLastStep = isLastStep
            )
        }
    }
}