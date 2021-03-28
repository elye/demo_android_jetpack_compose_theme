package com.example.jetpackcomposematerial.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposematerial.ui.theme.JetpackComposeMaterialTheme

@Composable
fun MainView(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CardSurface(
                color = JetpackComposeMaterialTheme.colors.primary,
                text = "Primary"
            )
            NormalSpacer()
            CardSurface(
                color = JetpackComposeMaterialTheme.colors.primaryVariant,
                text = "Primary Variant"
            )
            NormalSpacer()
            CardSurface(
                color = JetpackComposeMaterialTheme.colors.secondary,
                text = "Secondary"
            )
            NormalSpacer()
            CardSurface(
                color = JetpackComposeMaterialTheme.colors.secondaryVariant,
                text = "Secondary Variant"
            )
            NormalSpacer()
            CardSurface(
                color = JetpackComposeMaterialTheme.colors.error,
                text = "Error"
            )
        }
    }
}

@Composable
fun ColumnScope.CardSurface(color: Color, text: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        shape = JetpackComposeMaterialTheme.shapes.medium,
        elevation = JetpackComposeMaterialTheme.elevations.card,
        color = color
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text)
        }
    }
}
