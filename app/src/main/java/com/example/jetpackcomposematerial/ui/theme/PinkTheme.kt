package com.example.jetpackcomposematerial.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PinkDarkColorPalette = darkColors(
    primary = pink500,
    secondary = yellow200,
    primaryVariant = pink600,
    onPrimary = Color.White,
    surface = pinkDarkPrimary
)

private val PinkLightColorPalette = lightColors(
    primary = pink200,
    primaryVariant = pink500,
    surface = pinkLightPrimary

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
fun PinkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    JetpackComposeMaterialTheme(
        lightColorPalette = PinkLightColorPalette,
        darkColorPalette = PinkDarkColorPalette,
        darkTheme = darkTheme,
        content = content
    )
}
