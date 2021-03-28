package com.example.jetpackcomposematerial.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcomposematerial.ui.theme.JetpackComposeMaterialTheme

@Composable
fun LargeSpacer() {
    Spacer(modifier = Modifier.size(JetpackComposeMaterialTheme.paddings.largePadding))
}

@Composable
fun NormalSpacer() {
    Spacer(modifier = Modifier.size(JetpackComposeMaterialTheme.paddings.defaultPadding))
}

@Composable
fun SmallSpacer() {
    Spacer(modifier = Modifier.size(JetpackComposeMaterialTheme.paddings.smallPadding))
}

@Composable
fun TinySpacer() {
    Spacer(modifier = Modifier.size(JetpackComposeMaterialTheme.paddings.tinyPadding))
}
