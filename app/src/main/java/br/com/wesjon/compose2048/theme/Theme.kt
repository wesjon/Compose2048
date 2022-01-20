package br.com.wesjon.compose2048.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val colorPallette = lightColors(
    primary = ProjectColors.amber,
    background = ProjectColors.background,
)

@Composable
fun Compose2048Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = colorPallette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}