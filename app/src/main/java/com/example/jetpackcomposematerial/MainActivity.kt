package com.example.jetpackcomposematerial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.jetpackcomposematerial.ui.components.MainView
import com.example.jetpackcomposematerial.ui.components.SettingView
import com.example.jetpackcomposematerial.ui.components.ThemeType
import com.example.jetpackcomposematerial.ui.components.ThemeType.*
import com.example.jetpackcomposematerial.ui.theme.*
import dev.chrisbanes.accompanist.insets.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val darkMode = remember { mutableStateOf(false) }
            val themeType = remember { mutableStateOf(PURPLE) }

            when (themeType.value) {
                PURPLE -> PurpleTheme(darkTheme = darkMode.value) {
                    OverallView(darkMode, themeType)
                }
                YELLOW -> YellowTheme(darkTheme = darkMode.value) {
                    OverallView(darkMode, themeType)

                }
                BLUE -> BlueTheme(darkTheme = darkMode.value) {
                    OverallView(darkMode, themeType)

                }
                PINK -> PinkTheme(darkTheme = darkMode.value) {
                    OverallView(darkMode, themeType)
                }
            }
        }
    }

    @Composable
    fun OverallView(
        darkMode: MutableState<Boolean>,
        themeType: MutableState<ThemeType>
    ) {
        ProvideWindowInsets {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column {
                    Spacer(
                        modifier = Modifier
                            .background(color = JetpackComposeMaterialTheme.colors.primaryVariant)
                            .fillMaxWidth()
                            .statusBarsPadding()
                    )
                    SettingView(darkMode = darkMode, themeType = themeType)
                    MainView(Modifier.weight(1f))
                    Spacer(
                        modifier = Modifier
                            .background(color = JetpackComposeMaterialTheme.colors.primaryVariant)
                            .fillMaxWidth()
                            .navigationBarsPadding()
                    )
                }
            }
        }
    }
}
