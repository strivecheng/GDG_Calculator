package com.example.gdg_calculator.ui.landscape

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.gdg_calculator.data.getLandscapeCalculatorLeftData

/**
 * @author strivexing
 * @date 2022/8/8 22:56
 * @description
 */
@Composable
internal fun SeniorSymbolView(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        getLandscapeCalculatorLeftData().forEach {
            Row(modifier = Modifier.weight(1f)) {
                it.forEach { info ->
                    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = info.label, fontSize = 24.sp, color = Color.Black)
                    }
                }
            }
        }
    }
}