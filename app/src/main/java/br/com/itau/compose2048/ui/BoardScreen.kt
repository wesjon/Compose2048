package br.com.itau.compose2048.ui

import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.weight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import br.com.itau.compose2048.business.*

@Preview
@Composable
fun Board2048() {
    val game = remember { Game2048() }
    val boardState = remember { mutableStateOf(game.board) }

    Box(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color(0xFFA49381),
        shape = RoundedCornerShape(4.dp),
        gravity = ContentGravity.Center,
        padding = 8.dp
    ) {

        TopStatsPanel()

        Board(boardState.value)

        ActionButton("Left") {
            game.shift(Direction.LEFT)
            boardState.value = game.board.copyOf()
        }
        ActionButton("Right") {
            game.shift(Direction.RIGHT)
            boardState.value = game.board.copyOf()
        }
        ActionButton("Top") {
            game.shift(Direction.TOP)
            boardState.value = game.board.copyOf()
        }
        ActionButton("Bottom") {
            game.shift(Direction.BOTTOM)
            boardState.value = game.board.copyOf()
        }
    }

}

@Composable
fun Board(board: Array<IntArray>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(Game2048.BOARD_SIZE) { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(Game2048.BOARD_SIZE) { col ->
                    Cell(board[row][col])
                }
            }
        }
    }
}

@Composable
fun Cell(num: Int) {
    Box(
        backgroundColor = Color(0xFFCCCCCC),
        modifier = Modifier.weight(1f)
            .aspectRatio(1f),
        shape = RoundedCornerShape(4.dp),
        gravity = ContentGravity.Center
    ) {
        if (num > 0) {
            Text(
                text = "$num",
                style = TextStyle(
                    color = Color(0xFF6F665E),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Black
                )
            )
        }
    }
}

@Composable
fun ActionButton(text: String, action: () -> Unit) {
    Button(
        onClick = { action.invoke() },
        modifier = Modifier.preferredWidth(180.dp)
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Text(text)
    }
}
