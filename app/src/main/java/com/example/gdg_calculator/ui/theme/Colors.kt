package com.example.gdg_calculator.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * @author strivexing
 * @date 2022/8/7 22:57
 * @description
 */

data class Colors internal constructor(
    val ac: Color,
    val number: Color,
    val symbol: Color,
    val equal: Color,
    val background: Color,
    val topBg: Color
)

/**
 * The colors for the light mode. Do not define color values here.
 * The actual hex values belong into the [ColorPalette].
 */
internal val lightColors: Colors = with(ColorPalette) {
    Colors(
        AcLight,
        NumberLight,
        SymbolLight,
        EqualLight,
        BackgroundLight,
        BGLight
    )
}

/**
 * The colors for the dark mode. Do not define color values here.
 * The actual hex values belong into the [ColorPalette].
 */
internal val darkColors = with(ColorPalette) {
    Colors(
        AcDark,
        NumberDark,
        SymbolDark,
        EqualDark,
        BackgroundDark,
        BGDark
    )
}

internal val LocalColors = staticCompositionLocalOf { lightColors }
