package com.sdamashchuk.cocktaildetails.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.sdamashchuk.common.compose.component.VerticalDivider

@Composable
fun StepIndicator(
    modifier: Modifier = Modifier,
    step: Int,
    isFirstStep: Boolean,
    isLastStep: Boolean
) {
    val stepIndicatorHeight = remember { mutableStateOf(IntSize.Zero) }

    Box(
        modifier = modifier
            .fillMaxHeight()
            .onSizeChanged { size -> stepIndicatorHeight.value = size }
    ) {
        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight(if (isLastStep || isFirstStep) 0.5f else 1f)
                .align(if (isFirstStep) Alignment.BottomCenter else Alignment.TopCenter),
            thickness = 4.dp,
            color = MaterialTheme.colorScheme.primary
        )
        Surface(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
            color = MaterialTheme.colorScheme.primary,
            shape = MaterialTheme.shapes.large
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .wrapContentSize(),
                text = step.toString(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}