package coursera.week5.board

import coursera.week5.board.Direction.*


fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width, createSquareBoard(width))

@Suppress("DuplicatedCode")
data class SquareBoardImpl(override val width: Int) : SquareBoard {
    private val cells: MutableMap<Pair<Int, Int>, Cell> = mutableMapOf()

    init {
        for (i in 0 until width) {
            for (j in 0 until width) {
                cells[i to j] = Cell(i + 1, j + 1)
            }
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        if (i < 1 || i > width || j < 1 || j > width) return null

        return cells[i - 1 to j - 1]
    }

    override fun getCell(i: Int, j: Int): Cell {
        println(this)
        println("$i, $j")
        val cell: Cell? = getCellOrNull(i, j)

        if (cell != null) {
            return cell
        }

        throw IllegalArgumentException("Cell not found")
    }

    override fun getAllCells(): Collection<Cell> {
        return cells.values
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        if (i < 1 || i > width) return emptyList()

        val result = mutableListOf<Cell>()
        for (j in jRange) {
            if (j < 1 || j > width) continue
            result.add(getCell(i, j))
        }

        return result
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        if (j < 1 || j > width) return emptyList()

        val result = mutableListOf<Cell>()
        for (i in iRange) {
            if (i < 1 || i > width) continue
            result.add(getCell(i, j))
        }

        return result
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? = when (direction) {
        UP -> getCellOrNull(i - 1, j)
        DOWN -> getCellOrNull(i + 1, j)
        RIGHT -> getCellOrNull(i, j + 1)
        LEFT -> getCellOrNull(i, j - 1)
    }

}

data class GameBoardImpl<T>(
    override val width: Int,
    val squareBoard: SquareBoard
) : GameBoard<T>, SquareBoard by squareBoard {
    private val values: MutableMap<Cell, T?> = squareBoard.getAllCells().associateWith { null }.toMutableMap()

    override fun get(cell: Cell): T? = values[cell]

    override fun set(cell: Cell, value: T?) {
        values[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> = values.filterValues(predicate).keys

    override fun find(predicate: (T?) -> Boolean): Cell? = filter(predicate).toList().getOrNull(0)

    override fun any(predicate: (T?) -> Boolean): Boolean = filter(predicate).isNotEmpty()

    override fun all(predicate: (T?) -> Boolean): Boolean = values.size == filter(predicate).size

}
