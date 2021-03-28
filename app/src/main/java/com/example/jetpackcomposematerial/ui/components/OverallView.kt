package com.example.jetpackcomposematerial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.jetpackcomposematerial.ui.theme.JetpackComposeMaterialTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

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
                    Column(
                        modifier = Modifier.padding(
                            JetpackComposeMaterialTheme.paddings.largePadding
                        )
                    ) {
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
