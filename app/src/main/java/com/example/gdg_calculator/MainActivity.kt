package com.example.gdg_calculator

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gdg_calculator.ui.landscape.LandscapeNumberView
import com.example.gdg_calculator.ui.landscape.LandscapeTopView
import com.example.gdg_calculator.ui.landscape.SeniorSymbolView
import com.example.gdg_calculator.ui.portrait.PortraitNumberView
import com.example.gdg_calculator.ui.portrait.PortraitTopView
import com.example.gdg_calculator.ui.theme.CalculatorTheme
import com.example.gdg_calculator.ui.theme.GDG_CalculatorTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = remember {
                mutableStateOf(false)
            }
            GDG_CalculatorTheme(darkTheme = isDarkTheme.value) {
                rememberSystemUiController().run {
                    setStatusBarColor(CalculatorTheme.colors.topBg, true)
                    setNavigationBarColor(CalculatorTheme.colors.background, false)
                }
                MainScreen(isDarkTheme)
            }
        }
    }
}

@Composable
private fun MainScreen(isDarkTheme: MutableState<Boolean>) {
    val viewModel: MainViewModel = viewModel()
    val expandState = remember {
        mutableStateOf(false)
    }
    Scaffold(topBar = {
        TopAppBar(
            title = {},
            backgroundColor = CalculatorTheme.colors.topBg,
            actions = {
                Box {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier.clickable {
                            expandState.value = !expandState.value
                        }
                    )
                    DropdownMenu(
                        expanded = expandState.value,
                        offset = DpOffset(10.dp, 10.dp),
                        onDismissRequest = { expandState.value = false }) {
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Text(text = "历史记录")
                        }
                        DropdownMenuItem(onClick = {
                            expandState.value = false
                            viewModel.showThemeDialog.value = !viewModel.showThemeDialog.value
                        }) {
                            Text(text = "选择主题")
                        }
                    }
                }
            },
            elevation = 0.dp
        )
    }) {
        MainContent(it)
        ThemeDialog(isDarkTheme = isDarkTheme)
    }
}

@Composable
private fun ThemeDialog(isDarkTheme: MutableState<Boolean>) {
    val viewModel: MainViewModel = viewModel()
    if (viewModel.showThemeDialog.collectAsState().value) {
        val lightSelected = remember {
            mutableStateOf(!isDarkTheme.value)
        }
        val darkSelected = remember {
            mutableStateOf(isDarkTheme.value)
        }
        AlertDialog(
            onDismissRequest = { /*TODO*/ },
            title = { Text(text = "选择主题") },
            text = {
                Column(verticalArrangement = Arrangement.Center) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = lightSelected.value,
                            onClick = {
                                lightSelected.value = true
                                darkSelected.value = false
                            })
                        Text(text = "浅色", Modifier.padding(start = 16.dp))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = darkSelected.value,
                            onClick = {
                                darkSelected.value = true
                                lightSelected.value = false
                            })
                        Text(text = "深色", Modifier.padding(start = 16.dp))
                    }
                }
            },
            confirmButton = {
                LocalConfiguration.current.uiMode = Configuration.UI_MODE_NIGHT_YES
                Button(onClick = {
                    viewModel.showThemeDialog.value = false
                    if (lightSelected.value) {
                        isDarkTheme.value = false
                    } else if (darkSelected.value) {
                        isDarkTheme.value = true
                    }
                }) {
                    Text(text = "确定")
                }
            },
            dismissButton = {
                Button(onClick = { viewModel.showThemeDialog.value = false }) {
                    Text(text = "取消")
                }
            }
        )
    }

}

@Composable
private fun MainContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        when (LocalConfiguration.current.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                LandscapeTopView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.35f)
                        .background(CalculatorTheme.colors.topBg)
                )
                LandscapeKeyboardView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
            Configuration.ORIENTATION_PORTRAIT -> {
                PortraitTopView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.35f)
                        .background(CalculatorTheme.colors.topBg)
                )
                PortraitKeyboardView(
                    modifier = Modifier
                        .weight(1f)
                )
            }
            else -> {}
        }
    }
}

@Composable
private fun LandscapeKeyboardView(modifier: Modifier) {
    Row(modifier = modifier) {
        SeniorSymbolView(modifier = Modifier.weight(0.4f))
        LandscapeNumberView(modifier = Modifier.weight(0.6f))
    }
}

@Composable
private fun PortraitKeyboardView(modifier: Modifier) {
    PortraitNumberView(modifier = modifier)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GDG_CalculatorTheme {
//        MainScreen(mutableStateOf(false))
    }
}