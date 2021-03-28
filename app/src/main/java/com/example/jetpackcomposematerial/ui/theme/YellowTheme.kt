package com.example.jetpackcomposematerial.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val YellowLightColorPalette = lightColors(
    primary = yellow500,
    primaryVariant = yellow400,
    onPrimary = Color.Black,
    secondary = blue700,
    secondaryVariant = blue800,
    onSecondary = Color.White,
    surface = yellowLightPrimary
)

private val YellowDarkColorPalette = darkColors(
    primary = yellow200,
    primaryVariant = yellow400,
    onPrimary = Color.Black,
    secondary = blue200,
    secondaryVariant = blue800,
    onSecondary = Color.White,
    surface = yellowDarkPrimary
)

@Composable
fun YellowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    JetpackComposeMaterialTheme(
        lightColorPalette = YellowLightColorPalette,
        darkColorPalette = YellowDarkColorPalette,
        darkTheme = darkTheme,
        content = content
    )
}
