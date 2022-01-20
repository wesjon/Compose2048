package br.com.wesjon.compose2048

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import br.com.wesjon.compose2048.theme.Compose2048Theme
import br.com.wesjon.compose2048.ui.Board2048

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose2048Theme {
                Surface(color = colors.background) {
                    Board2048()
                }
            }
        }
    }
}