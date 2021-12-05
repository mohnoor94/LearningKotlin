package coursera.week5.games.gameOfFifteen

import kotlin.random.Random

interface GameOfFifteenInitializer {
    /*
     * Even permutation of numbers 1..15
     * used to initialize the first 15 cells on a board.
     * The last cell is empty.
     */
    val initialPermutation: List<Int>
}

class RandomGameInitializer : GameOfFifteenInitializer {
    /*
     * Generate a random permutation from 1 to 15.
     * `shuffled()` function might be helpful.
     * If the permutation is not even, make it even (for instance,
     * by swapping two numbers).
     */
    override val initialPermutation by lazy {
        val randomOrderedList: MutableList<Int> = (1..15).shuffled().toMutableList()

        while (!isEven(randomOrderedList)) {
            val random1 = Random.nextInt(15)
            val random2 = Random.nextInt(15)
            if (random1 != random2) {
                val tmp = randomOrderedList[random1]
                randomOrderedList[random1] = randomOrderedList[random2]
                randomOrderedList[random2] = tmp
            }
        }

        return@lazy randomOrderedList
    }
}

