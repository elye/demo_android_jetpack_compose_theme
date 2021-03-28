package com.example.jetpackcomposematerial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.jetpackcomposematerial.ui.components.MainView
import com.example.jetpackcomposematerial.ui.components.SettingView
import com.example.jetpackcomposematerial.ui.components.ThemeType
import com.example.jetpackcomposematerial.ui.components.ThemeType.*
import com.example.jetpackcomposematerial.ui.theme.*
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

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
            Column {
                Scaffold(
                    modifier = Modifier.weight(1f),
                    topBar = { MyTopAppBar(themeType.value) },
                    isFloatingActionButtonDocked = true,
                    floatingActionButton = { MyFloatingButton() }
                ) {
                    Surface(modifier = Modifier.fillMaxWidth()) {
                        Column (modifier = Modifier.padding(
                            JetpackComposeMaterialTheme.paddings.largePadding
                        )){
                            SettingView(darkMode = darkMode, themeType = themeType)
                            MainView(Modifier.weight(1f))
                        }
                    }
                }
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


@Composable
fun MyTopAppBar(theme: ThemeType) {
    Column {
        Spacer(
            modifier = Modifier
                .background(color = JetpackComposeMaterialTheme.colors.primaryVariant)
                .fillMaxWidth()
                .statusBarsPadding()
        )
        TopAppBar(
            title = { Text(theme.name) },
            backgroundColor = JetpackComposeMaterialTheme.colors.primary
        )
    }
}

@Composable
fun MyFloatingButton() {
    val scope = rememberCoroutineScope()
    FloatingActionButton(onClick = {
    }) {
        Text("X")
    }
}
