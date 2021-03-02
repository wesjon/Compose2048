package br.com.itau.compose2048.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.itau.compose2048.theme.ProjectColors
import br.com.itau.compose2048.theme.shapes
import br.com.itau.compose2048.theme.typography

@Preview
@Composable
fun TopStatsPanel() {
    Row(
        modifier = Modifier.height(125.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(ProjectColors.amber, RoundedCornerShape(4.dp))
                .size(125.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "2048",
                style = typography.h1.copy(
                    color = ProjectColors.white
                )
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                HighlightCard("Score", "200")
                HighlightCard("Best", "220")
            }

            Button(
                onClick = {},
                modifier = Modifier.fillMaxSize(),
//                colors =ButtonColors.
            ) {
                Text(
                    "New".toUpperCase(),
                    style = typography.h2.copy(color = ProjectColors.white)
                )
            }
        }
    }
}

@Composable
fun HighlightCard(title: String, value: String) {
    Box(
        modifier = Modifier
            .height(66.dp)
            .background(ProjectColors.brown, shapes.small)
//            .weight(1f)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(title.toUpperCase(), style = typography.h2.copy(color = ProjectColors.white))
            Text(value, style = typography.caption.copy(color = ProjectColors.white))
        }
    }
}