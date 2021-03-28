package com.example.jetpackcomposematerial.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val BlueDarkColorPalette = darkColors(
    primary = blue700,
    onPrimary = Color.White,
    primaryVariant = blue800,
    secondary = yellow500,
    surface = blueDarkPrimary
)

private val BlueLightColorPalette = lightColors(
    primary = blue200,
    secondary = blue800,
    onSecondary = Color.White,
    surface = blueLightPrimary

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BlueTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    JetpackComposeMaterialTheme(
        lightColorPalette = BlueLightColorPalette,
        darkColorPalette = BlueDarkColorPalette,
        darkTheme = darkTheme,
        content = content
    )
}
