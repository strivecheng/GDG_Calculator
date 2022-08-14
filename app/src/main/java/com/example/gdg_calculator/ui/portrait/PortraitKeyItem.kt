package com.example.gdg_calculator.ui.portrait

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.gdg_calculator.data.KeyType
import com.example.gdg_calculator.data.NumberButtonInfo
import com.example.gdg_calculator.ui.theme.CalculatorTheme

/**
 * @author strivexing
 * @date 2022/8/8 22:54
 * @description
 */
@Composable
internal fun PortraitKeyItem(info: NumberButtonInfo, modifier: Modifier, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .then(modifier)
            .background(
                color = when (info.type) {
                    KeyType.CLEAR -> CalculatorTheme.colors.ac
                    KeyType.NUMBER -> CalculatorTheme.colors.number
                    KeyType.SYMBOL -> CalculatorTheme.colors.symbol
                    KeyType.EQUAL -> CalculatorTheme.colors.equal
                }
            )
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = info.label,
            color = Color.Black,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
        )
    }
}