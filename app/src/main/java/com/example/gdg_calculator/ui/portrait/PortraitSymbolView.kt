package com.example.gdg_calculator.ui.portrait

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gdg_calculator.data.getPortraitCalculatorTopData
import com.example.gdg_calculator.ui.theme.CalculatorTheme

/**
 * @author strivexing
 * @date 2022/8/9 09:11
 * @description
 */
@Composable
internal fun PortraitSymbolView() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        getPortraitCalculatorTopData().forEach {
            Text(
                text = it.label,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }

        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "",
            tint = CalculatorTheme.colors.equal,
            modifier = Modifier.weight(1f)
        )
    }
}