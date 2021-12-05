package coursera.week5.games.gameOfFifteen

import coursera.week5.board.Cell
import coursera.week5.board.Direction
import coursera.week5.board.GameBoard
import coursera.week5.board.createGameBoard
import coursera.week5.games.game.Game

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game = GameOfFifteen(initializer)

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {
    private val board: GameBoard<Int?> = createGameBoard(4)

    companion object {
        val FINAL_RESULT: MutableList<Int?> = (1..15).toMutableList<Int?>().apply { add(null) }
    }

    override fun initialize() {
        val values = initializer.initialPermutation
        board.getAllCells().forEachIndexed { index, cell ->
            if (index == 15) return@forEachIndexed
            board[cell] = values[index]
        }
    }

    override fun canMove(): Boolean = true

    override fun hasWon(): Boolean = FINAL_RESULT == board.getAllCells().map { board[it] }

    override fun processMove(direction: Direction) {
        board.apply {
            val emptyCell: Cell = find { it == null }!!
            val goal: Cell = emptyCell.getNeighbour(direction.reversed())!!
            board[emptyCell] = board[goal]
            board[goal] = null
        }
    }

    override fun get(i: Int, j: Int): Int? = board.run { get(getCell(i, j)) }
}

fun main() {
    val newGameOfFifteen = newGameOfFifteen(RandomGameInitializer())
    newGameOfFifteen.initialize()
    newGameOfFifteen.hasWon()
    newGameOfFifteen.processMove(Direction.UP)
}

