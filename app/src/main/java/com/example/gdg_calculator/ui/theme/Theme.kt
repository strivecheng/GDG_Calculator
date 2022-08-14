package com.example.gdg_calculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Colors as MaterialColors

@Composable
fun GDG_CalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = remember(darkTheme) { if (darkTheme) darkColors else lightColors }
    val materialColors = remember(darkTheme) { getMaterialColors(darkTheme) }

    MaterialTheme(
        colors = materialColors,
        typography = Typography,
        shapes = Shapes,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colors.onBackground,
            LocalContentAlpha provides 1f,
            LocalColors provides colors,
            content = content
        )
    }
}

private fun getMaterialColors(isDarkMode: Boolean): MaterialColors {
    with(CalculatorTheme.colorPalette) {
        return if (isDarkMode) {
            MaterialColors(
                primary = AcDark,
                primaryVariant = AcDark,
                secondary = AcDark,
                secondaryVariant = AcDark,
                background = BackgroundDark,
                surface = SurfaceDark,
                error = AcDark,
                onPrimary = ForegroundDark,
                onSecondary = Color.Black,
                onBackground = Color.White,
                onSurface = ForegroundDark,
                onError = Color.Black,
                isLight = false,
            )
        } else {
            MaterialColors(
                primary = AcLight,
                primaryVariant = AcLight,
                secondary = AcLight,
                secondaryVariant = AcLight,
                background = BackgroundLight,
                surface = SurfaceLight,
                error = AcLight,
                onPrimary = ForegroundLight,
                onSecondary = Color.Black,
                onBackground = Color.Black,
                onSurface = ForegroundLight,
                onError = Color.White,
                isLight = false,
            )
        }
    }
}

object CalculatorTheme {
    val colorPalette = ColorPalette
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}