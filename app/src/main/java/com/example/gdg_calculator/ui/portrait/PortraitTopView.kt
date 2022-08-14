package com.example.gdg_calculator.ui.portrait

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gdg_calculator.MainViewModel

/**
 * @author strivexing
 * @date 2022/8/9 09:46
 * @description
 */
@Composable
internal fun PortraitTopView(modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 6.dp)) {
        FormulaView()
        PreviewResultView()
    }
}

@Composable
private fun FormulaView() {
    val viewModel = viewModel<MainViewModel>()
    val collectAsState = viewModel.showText.collectAsState()
    Box {
        Text(
            text = collectAsState.value,
            fontSize = 80.sp,
            color = Color.Black,
            textAlign = TextAlign.End,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun PreviewResultView() {
    Box {
        Text(
            text = "0",
            fontSize = 60.sp,
            color = Color.Gray,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
    }
}