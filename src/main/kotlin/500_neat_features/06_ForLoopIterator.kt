package `500_neat_features`

import java.util.*

// We can use a `for` loop for any object by defining the `iterator` function as operator.

class RandomGenerator(val size: Int, private val random: Random = Random(size.toLong())) {
    operator fun iterator(): RandomGeneratorIterator = RandomGeneratorIterator(this)
    fun get(): Int = random.nextInt(size)
}

class RandomGeneratorIterator(
    private val randomGenerator: RandomGenerator,
    private var times: Int = 0,
) : Iterator<RandomGenerator> {
    override fun hasNext(): Boolean = times++ < randomGenerator.size
    override fun next(): RandomGenerator = randomGenerator
}

fun main() {
    val randoms = RandomGenerator(10)

    for (num in randoms) {
        println(num.get())
    }
}
