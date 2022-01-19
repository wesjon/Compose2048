package br.com.itau.compose2048.ui


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.itau.compose2048.business.Direction
import br.com.itau.compose2048.business.Game2048
import br.com.itau.compose2048.theme.ProjectColors
import br.com.itau.compose2048.theme.shapes

@Preview
@ExperimentalFoundationApi
@Composable
fun Board2048() {
    val game = remember { Game2048() }
    val boardState = remember { mutableStateOf(game.board) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        TopStatsPanel()

        Board(boardState.value)

        ActionsPannel { direction ->
            game.shift(direction)
            boardState.value = game.board.copyOf()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Board(board: Array<IntArray>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(Game2048.BOARD_SIZE),
        modifier = modifier
            .clip(shapes.large)
            .background(color = ProjectColors.surface)
            .padding(4.dp),
    ) {
        items(Game2048.BOARD_SIZE * Game2048.BOARD_SIZE) { index ->
            val row = index / Game2048.BOARD_SIZE
            val col = index % Game2048.BOARD_SIZE

            Cell(board[row][col], Modifier.padding(4.dp))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ActionsPannel(
    onDirectionChanged: (Direction) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(Direction.values().size) { index ->
            val item = Direction.values()[index]
            ActionButton(item) { direction ->
                onDirectionChanged(direction)
            }
        }
    }
}

@Composable
fun Cell(num: Int, modifier: Modifier) {
    val bgColor = if (num > 0) ProjectColors.piece else ProjectColors.piece.copy(alpha = 0.5f)
    Column(
        modifier = CombinedModifier(
            outer = modifier,
            inner = Modifier
                .background(bgColor, RoundedCornerShape(4.dp))
                .aspectRatio(1f)
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
fun ActionButton(
    direction: Direction,
    action: (Direction) -> Unit
) {
    Button(
        onClick = { action.invoke(direction) }
    ) {
        Text(direction.name)
    }
}
