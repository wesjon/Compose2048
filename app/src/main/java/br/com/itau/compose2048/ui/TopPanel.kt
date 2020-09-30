package br.com.itau.compose2048.ui

import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.weight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopStatsPanel() {
    Row(
        modifier = Modifier.height(125.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxHeight()
                .weight(1f),
            backgroundColor = Color(0xffECCC5F),
            gravity = ContentGravity.Center
        ) {
            Text(
                "2048",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Black
                )
            )
        }
        HighlightCard("Score", "200")
        HighlightCard("Best", "200")
    }
}

@Composable
fun HighlightCard(title: String, value: String) {
    Box(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.height(66.dp)
            .weight(1f)
            .fillMaxWidth(),
        backgroundColor = Color(0xff3D3A33),
        gravity = Alignment.Center
    ) {
        val titleStyle = TextStyle(
            color = Color.White,
            fontSize = 18.sp,
            FontWeight.Black
        )
        val valueStyle = titleStyle.copy(fontSize = 24.sp)

        Column {
            Text(title, style = titleStyle)
            Text(value, style = valueStyle)
        }
    }
}