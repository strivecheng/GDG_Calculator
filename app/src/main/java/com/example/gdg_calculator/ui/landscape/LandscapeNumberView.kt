package com.example.gdg_calculator.ui.landscape

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gdg_calculator.MainViewModel
import com.example.gdg_calculator.data.getLandscapeCalculatorRightData

/**
 * @author strivexing
 * @date 2022/8/8 22:53
 * @description
 */
@Composable
internal fun LandscapeNumberView(modifier: Modifier) {
    val viewModel = viewModel<MainViewModel>()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        getLandscapeCalculatorRightData().forEach {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                it.forEach { info ->
                    LandscapeKeyItem(
                        info, modifier = Modifier
                            .weight(1f)
                            .aspectRatio(2f)
                    ) {
                        viewModel.update(info.label)
                    }
                }
            }
        }
    }
}