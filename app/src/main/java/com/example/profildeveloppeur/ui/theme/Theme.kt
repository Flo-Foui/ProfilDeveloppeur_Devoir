package com.example.profildeveloppeur.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = LightSurface,
    primaryContainer = Blue90,
    onPrimaryContainer = Ink,
    secondary = Teal40,
    onSecondary = LightSurface,
    secondaryContainer = Teal90,
    onSecondaryContainer = Ink,
    background = LightBackground,
    onBackground = Ink,
    surface = LightSurface,
    onSurface = Ink,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = InkVariant
)

private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    onPrimary = Blue20,
    primaryContainer = Blue40,
    onPrimaryContainer = Blue90,
    secondary = Teal80,
    onSecondary = Teal20,
    secondaryContainer = Teal40,
    onSecondaryContainer = Teal90,
    background = DarkBackground,
    onBackground = Snow,
    surface = DarkSurface,
    onSurface = Snow,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = SnowVariant
)

// Pas de dynamicColor : je garde mes propres couleurs sur tous les téléphones.
@Composable
fun ProfilDeveloppeurTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = ProfilTypography,
        shapes = ProfilShapes,
        content = content
    )
}
