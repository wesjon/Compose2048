package br.com.wesjon.compose2048.business

class Game2048 {
    val board = arrayOf(
        intArrayOf(4, 0, 0, 0),
        intArrayOf(0, 0, 2, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 2, 0, 2)
    )

    fun shift(direction: Direction) {
        val directionRange = when (direction) {
            Direction.LEFT, Direction.TOP -> (0 until BOARD_SIZE)
            Direction.RIGHT, Direction.BOTTOM -> (0 until BOARD_SIZE).reversed()
        }

        repeat(BOARD_SIZE) {
            doInMatrix(directionRange) {
                when (direction) {
                    Direction.LEFT -> {
                        mergeCells(it.row, it.col, it.row, it.col + 1)
                    }
                    Direction.RIGHT -> {
                        mergeCells(it.row, it.col, it.row, it.col - 1)
                    }
                    Direction.TOP -> {
                        mergeCells(it.row, it.col, it.row + 1, it.col)
                    }
                    Direction.BOTTOM -> {
                        mergeCells(it.row, it.col, it.row - 1, it.col)
                    }
                }
            }
        }

        addRandom2()
    }

    fun addRandom2() {
        val nullCoordinates = mutableListOf<Coordinate>()
        doInMatrix(acceptablePositions, { it == 0 }) {
            nullCoordinates += it
        }

        val randomCoordinate = nullCoordinates.random()
        board[randomCoordinate.row][randomCoordinate.col] = 2
    }

    private fun doInMatrix(
        range: IntProgression,
        condition: (Int) -> Boolean = { true },
        action: (Coordinate) -> Unit,
    ) {
        for (i in range) {
            for (j in range) {
                val value = board[i][j]
                if (condition.invoke(value)) {
                    val coordinateForPosition = getCoordinate(value, i, j)
                    action.invoke(coordinateForPosition)
                }
            }
        }
    }

    private fun getCoordinate(value: Int, row: Int, col: Int): Coordinate {
        val left = if (col - 1 >= 0) {
            board[row][col - 1]
        } else {
            OFF_BOARD_POSITION
        }

        val right = if (col + 1 < BOARD_SIZE) {
            board[row][col + 1]
        } else {
            OFF_BOARD_POSITION
        }

        val top = if (row - 1 >= 0) {
            board[row - 1][col]
        } else {
            OFF_BOARD_POSITION
        }

        val bottom = if (row + 1 < BOARD_SIZE) {
            board[row + 1][col]
        } else {
            OFF_BOARD_POSITION
        }

        return Coordinate(
            value = value,
            row = row,
            col = col,
            left = left,
            right = right,
            top = top,
            bottom = bottom
        )
    }

    private fun mergeCells(row: Int, col: Int, mergeRow: Int, mergeCol: Int) {
        if (mergeRow in acceptablePositions && mergeCol in acceptablePositions) {
            val value = board[row][col]
            val mergeCellValue = board[mergeRow][mergeCol]

            if (value == mergeCellValue) {
                board[row][col] = value * 2
                board[mergeRow][mergeCol] = 0
            } else if (value == 0) {
                board[row][col] = board[mergeRow][mergeCol]
                board[mergeRow][mergeCol] = 0
            }
        }
    }

    companion object {
        private const val OFF_BOARD_POSITION = -1
        const val BOARD_SIZE = 4
        private val acceptablePositions = 0 until BOARD_SIZE
    }
}

