package com.sdamashchuk.cocktaildetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Ingredient(
    modifier: Modifier = Modifier,
    ingredientText: String,
    measureText: String,
    stepNumber: Int,
    isFirstStep: Boolean,
    isLastStep: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(
                start = 10.dp,
                end = 16.dp
            )
    ) {
        StepIndicator(
            step = stepNumber,
            isFirstStep = isFirstStep,
            isLastStep = isLastStep
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = if (isFirstStep) 0.dp else 8.dp,
                    bottom = 8.dp
                )
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = ingredientText,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = measureText,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}