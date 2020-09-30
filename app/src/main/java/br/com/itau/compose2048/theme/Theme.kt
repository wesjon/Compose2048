package br.com.itau.compose2048.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val colorPallette = lightColors(
    primary = amber,
    background = background,
)

@Composable
fun Compose2048Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = colorPallette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}