package `100_sequences`

import java.math.BigInteger
import kotlin.random.Random


fun main() {
    // Here, we want to create a sequence from scratch, and not from a current collection.
    // Sequence is an interface which have one method: iterator()

    // Sequences and Collections do not extend/implement the same base class/interface since we need to differentiate
    // how lazy-vs-eager evaluation is done.
    // but they have the same exact methods and functions, so that we can switch from one to the other super easily.

    // Generating a sequence:
    println("Generating a sequence:")
    val infiniteRandomGenerator: Sequence<Int> = generateSequence { Random.nextInt() }

    val seq = generateSequence {
        Random.nextInt(5).takeIf { it > 0 }
    }

    println(seq.toList())
    println("*".repeat(50))

    // Read until "exit" is typed:
    println("Read until \"exit\" is typed:")
//    println("Write things...")
//    val input = generateSequence {
//        readLine().takeIf { it != "exit" }
//    }
//    println(input.toList())

    println("*".repeat(50))

    // Generate an infinite sequence:
    println("Generate an infinite sequence:")

    val numbers = generateSequence(0) { it + 1 }
    println(numbers.take(5).toList()) // [0, 1, 2, 3, 4]
    println(numbers.take(10).toList()) // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    val bigNumbers = generateSequence(BigInteger.ZERO) { it + BigInteger.ONE } // to avoid int overflow for big numbers.
    println(bigNumbers.take(10).toList())

    println("*".repeat(50))

    // yield - a library function, not a built-in language feature.
    println("yield:")

    val numbers2: Sequence<Int> = sequence {
        var x = 0
        while (true) yield(x++) // depends on previous values!
    }

    println(numbers2.take(5).toList()) // [0, 1, 2, 3, 4]
    println(numbers2.take(10).toList()) // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    // You can use:
    // - yield: to yield a specific value
    // - yieldAll(list) to yield a list
    // - yieldAll(collection) to yield a collection
    // - multiple yields, and do any computations in between.

    fun mySequence() = sequence {
        println("yield one element")
        yield(1)
        println("yield a range")
        yieldAll(3..5)
        println("yield a list") // we will not reach this for the given use
        yieldAll(listOf(7, 9))
    }

    println(mySequence()
        .map { it * it }
        .filter { it > 10 }
        .first()
    )
    // yield one element
    // yield a range
    // 16

    println()

    fun fibonacci1(): Sequence<Int> = sequence {
        var first = 0
        yield(first)

        var second = 1
        yield(second)

        while (true) {
            val tmp = first
            first = second
            second = tmp + first

            yield(second)
        }
    }

    fun fibonacci2(): Sequence<Int> = sequence {
        var elements = Pair(0, 1)

        while (true) {
            yield(elements.first)
            elements = Pair(elements.second, elements.first + elements.second)
        }
    }

    println(fibonacci1().take(10).toList())
    println(fibonacci2().take(10).toList())
}
