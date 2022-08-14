package com.example.gdg_calculator.ui.portrait

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gdg_calculator.MainViewModel
import com.example.gdg_calculator.data.getPortraitCalculatorData

/**
 * @author strivexing
 * @date 2022/8/8 22:54
 * @description
 */
@Composable
internal fun PortraitNumberView(modifier: Modifier) {
    val viewModel = viewModel<MainViewModel>()
    val collectAsState = viewModel.showText.collectAsState()
    Column(
        modifier = modifier,
    ) {
        PortraitSymbolView()
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 6.dp),
        ) {
            getPortraitCalculatorData().forEach {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    it.forEach { info ->
                        PortraitKeyItem(
                            info, modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                        ) {
                            viewModel.update(info.label)
                        }
                    }
                }
            }
        }
    }
}