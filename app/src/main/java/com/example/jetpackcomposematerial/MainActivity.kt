package com.example.jetpackcomposematerial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.jetpackcomposematerial.ui.components.MainView
import com.example.jetpackcomposematerial.ui.components.SettingView
import com.example.jetpackcomposematerial.ui.components.ThemeType.*
import com.example.jetpackcomposematerial.ui.theme.BlueTheme
import com.example.jetpackcomposematerial.ui.theme.PinkTheme
import com.example.jetpackcomposematerial.ui.theme.PurpleTheme
import com.example.jetpackcomposematerial.ui.theme.YellowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode = remember { mutableStateOf(false) }
            val themeType = remember { mutableStateOf(PURPLE) }

            when(themeType.value) {
                PURPLE -> PurpleTheme(darkTheme = darkMode.value) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Column {
                            SettingView(darkMode, themeType)
                            MainView()
                        }
                    }
                }
                YELLOW -> YellowTheme(darkTheme = darkMode.value) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Column {
                            SettingView(darkMode, themeType)
                            MainView()
                        }
                    }
                }
                BLUE -> BlueTheme(darkTheme = darkMode.value) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Column {
                            SettingView(darkMode, themeType)
                            MainView()
                        }
                    }
                }
                PINK -> PinkTheme(darkTheme = darkMode.value) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Column {
                            SettingView(darkMode, themeType)
                            MainView()
                        }
                    }
                }
            }
        }
    }
}
