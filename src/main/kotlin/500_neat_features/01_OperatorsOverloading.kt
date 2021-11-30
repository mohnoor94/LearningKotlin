package `500_neat_features`

import `500_neat_features`.Digit.*

// We can override some specific operators in Kotlin using:
// - specific names.
// - the `operator` keyword.

// The Arithmetic operators we can override:
// plus +
// minus -
// times *
// div /
// mod %

// The unary operators we can override (functions without parameters):
// unaryPlus +
// unaryMinus -
// not !
// inc ++x, x++
// dec --x, x--

enum class Digit(val value: Int) {
    ONE(1),
    TWO(2),
    THREE(3);

    // Arithmetic
    operator fun plus(number: Int): Int {
        return this.value + number
    }

    // Unary
    operator fun unaryMinus(): Int {
        return -this.value
    }
}

fun main() {
    println(ONE.plus(5))
    println(-ONE)
}
