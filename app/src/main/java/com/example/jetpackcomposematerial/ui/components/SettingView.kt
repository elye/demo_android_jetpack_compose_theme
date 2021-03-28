package com.example.jetpackcomposematerial.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposematerial.R
import com.example.jetpackcomposematerial.ui.components.ThemeType.*
import com.example.jetpackcomposematerial.ui.theme.JetpackComposeMaterialTheme

@Composable
fun SettingView(
    modifier: Modifier = Modifier,
    darkMode: MutableState<Boolean>,
    themeType: MutableState<ThemeType>
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        Column{
            DarkModeCheckBox(darkMode)
            SmallSpacer()
            ThemePickRadioGroup(themeType)
            LargeSpacer()
        }
    }
}

@Composable
fun DarkModeCheckBox(darkMode: MutableState<Boolean>) {
    Row {
        Checkbox(
            checked = darkMode.value,
            onCheckedChange = { checked -> darkMode.value = checked },
        )
        SmallSpacer()
        Text(text = stringResource(R.string.dark_mode))
    }
}

@Composable
fun ThemePickRadioGroup(themeType: MutableState<ThemeType>) {

    Column {
        Text(text = stringResource(R.string.theme_select))
        TinySpacer()
        Row {
            TinySpacer()
            RadioButton(selected = themeType.value == PURPLE, onClick = {
                themeType.value = PURPLE
            })
            Text(
                text = PURPLE.name,
                modifier = Modifier
                    .clickable(onClick = { themeType.value = PURPLE })
                    .padding(start = JetpackComposeMaterialTheme.paddings.tinyPadding)
            )
            TinySpacer()
            RadioButton(selected = themeType.value == YELLOW, onClick = {
                themeType.value = YELLOW
            })
            Text(
                text = YELLOW.name,
                modifier = Modifier
                    .clickable(onClick = { themeType.value = YELLOW })
                    .padding(start = JetpackComposeMaterialTheme.paddings.tinyPadding)
            )
            TinySpacer()
            RadioButton(selected = themeType.value == BLUE, onClick = {
                themeType.value = BLUE
            })
            Text(
                text = BLUE.name,
                modifier = Modifier
                    .clickable(onClick = { themeType.value = BLUE })
                    .padding(start = JetpackComposeMaterialTheme.paddings.tinyPadding)
            )
            TinySpacer()
            RadioButton(selected = themeType.value == PINK, onClick = {
                themeType.value = PINK
            })
            Text(
                text = PINK.name,
                modifier = Modifier
                    .clickable(onClick = { themeType.value = PINK })
                    .padding(start = JetpackComposeMaterialTheme.paddings.tinyPadding)
            )
        }
    }
}

enum class ThemeType {
    PURPLE,
    YELLOW,
    BLUE,
    PINK
}
