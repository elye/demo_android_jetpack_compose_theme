package com.example.jetpackcomposematerial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import com.example.jetpackcomposematerial.ui.components.OverallView
import com.example.jetpackcomposematerial.ui.components.ThemeType.*
import com.example.jetpackcomposematerial.ui.theme.BlueTheme
import com.example.jetpackcomposematerial.ui.theme.PinkTheme
import com.example.jetpackcomposematerial.ui.theme.PurpleTheme
import com.example.jetpackcomposematerial.ui.theme.YellowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val darkMode = remember { mutableStateOf(false) }
            val themeType = remember { mutableStateOf(PURPLE) }

            val themeFunction: @Composable (
                isDarkMode: Boolean, content: @Composable () -> Unit
            ) -> Unit =
                when (themeType.value) {
                    PURPLE -> { isDarkMode, content -> PurpleTheme(isDarkMode, content) }
                    YELLOW -> { isDarkMode, content -> YellowTheme(isDarkMode, content) }
                    BLUE -> { isDarkMode, content -> BlueTheme(isDarkMode, content) }
                    PINK -> { isDarkMode, content -> PinkTheme(isDarkMode, content) }
                }

            themeFunction.invoke(darkMode.value) {
                OverallView(darkMode, themeType)
            }
        }
    }
}
