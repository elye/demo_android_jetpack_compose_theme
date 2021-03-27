package com.example.jetpackcomposematerial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposematerial.ui.theme.JetpackComposeMaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode = remember { mutableStateOf(true) }
            JetpackComposeMaterialTheme(darkTheme = darkMode.value) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        DarkModeCheckBox(darkMode)
                        MainView()
                    }
                }
            }
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
fun MainView() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(JetpackComposeMaterialTheme.paddings.largePadding)
        ) {
            CardSurface(
                color = MaterialTheme.colors.primary,
                text = "Primary"
            )
            NormalSpacer()
            CardSurface(
                color = MaterialTheme.colors.primaryVariant,
                text = "Primary Variant"
            )
            NormalSpacer()
            CardSurface(
                color = MaterialTheme.colors.secondary,
                text = "Secondary"
            )
            NormalSpacer()
            CardSurface(
                color = MaterialTheme.colors.secondaryVariant,
                text = "Secondary Variant"
            )
        }
    }
}

@Composable
fun NormalSpacer() {
    Spacer(modifier = Modifier.size(JetpackComposeMaterialTheme.paddings.defaultPadding))
}

@Composable
fun SmallSpacer() {
    Spacer(modifier = Modifier.width(JetpackComposeMaterialTheme.paddings.smallPadding))
}

@Composable
fun ColumnScope.CardSurface(color: Color, text: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        shape = JetpackComposeMaterialTheme.shapes.medium,
        elevation = JetpackComposeMaterialTheme.elevations.card,
        color = color
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeMaterialTheme {
        MainView()
    }
}
