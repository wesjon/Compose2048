package br.com.itau.compose2048

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import br.com.itau.compose2048.theme.Compose2048Theme
import br.com.itau.compose2048.ui.Board2048

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
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