package `100_sequences`

fun main() {
    // All the extension functions for the collections are defined as `inline` functions:
    // filter, map, any, find, groupBy, ...

    // This is good for performance, BUT
    // it may cause a more important issue for performance,
    // As each step (function) will create a NEW collection to store the step result.

    // Example:
    val numbers = listOf(1, 2, -3) // [1, 2, -3]

    val maxOddSquare = numbers
        .map { it * it } // new collection created --> [1, 4, 9]
        .filter { it % 2 == 1 } // new collection created --> [1, 9]
        .maxOrNull() // 9
    println(maxOddSquare) // 9

    // Keep in mind>>>
    // Operations on Collections:
    // > Lambdas are inlined > no performance overhead
    // > BUT: Intermediate collections are created for chained calls.

    // How to avoid this?
    // Use Sequences!
    // Sequences are similar to Streams in Java, but they are named as "Sequences" to keep things works good when we
    // have a mixed code base (Java and Kotlin).

    // > Sequences perform the operations in a **lazy** manner (just like the streams in Java).
    // >>> We don't do any operation unless it is needed (in terminal operations).
    // >>> If we have a terminal operation which need only one answer, like find() or first()
    // >>> We will stop immediately when we find this answer and don't do ANY operation for all the chained operations,
    // >>> Not only the last one.
    // >>>>> Intermediate Operations: returns another sequence. (no actual collection - a reference for some sequence).
    // >>>>> Terminal Operations: returns a result.
    // > Collections perform the operations in an **eager** manner.

    // Collections are evaluated horizontally (one-by-one, full operation) - lazily.
    // Sequences are evaluated vertically (all operations on the same element) - eagerly.

    // - a sequence is potentially infinite (like a stream).

    // Converting from Collections to Sequences is easy.
    // Just use `toSequence()` method, Which build a sequence out of a list, then use it.

    val maxOddSquare2 = numbers
        .asSequence() // << because of this, no intermediate collections will be generated.
        .map { it * it }
        .filter { it % 2 == 1 }
        .maxOrNull() // 9 << here, we need a result, so all the computations are performed (not before).
    println(maxOddSquare) // 9

    println("*".repeat(50))
    // The order of operations is of-course important
    // It could affect not only the final result, but the number of operations we will execute with sequences.

    fun m(i: Int): Int {
        print("m$i ")
        return i * i
    }

    fun f(i: Int): Boolean {
        print("f$i ")
        return i % 2 == 0
    }

    val numbers2 = listOf(1, 2, 3, 4)

    numbers2
        .asSequence()
        .map(::m)
        .filter(::f)
        .toList() // m1 f1 m2 f4 m3 f9 m4 f16

    println()

    numbers2
        .asSequence()
        .filter(::f)
        .map(::m)
        .toList() // f1 f2 m2 f3 f4 m4
    // fewer operations are evaluated

    println()

    numbers
        .asSequence()
        .filter(::f)
        .map(::m) // nothing will be printed as we don't have a "terminal" operation - nothing need to be calculated.
}
