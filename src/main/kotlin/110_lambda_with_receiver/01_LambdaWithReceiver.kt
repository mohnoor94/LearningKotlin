package `110_lambda_with_receiver`

import kotlin.text.StringBuilder

fun main() {
    // Union of Extension Functions and Lambdas

    // 1. `with` Function
    println("1. `with` Function")

    // The normal way:
    val sb1 = StringBuilder()
    sb1.appendLine("Alphabet: ")
    for (c in 'a'..'z') sb1.append(c)
    println(sb1.toString())
    println()

    // with `with` function

    val sb2 = StringBuilder()
    with(sb2) {
        appendLine("Alphabet: ")
        for (c in 'a'..'z') append(c)
        println(toString())
    }
    println()

    // with `buildString` function

    val s: String = buildString {
        appendLine("Alphabet: ")
        for (c in 'a'..'z') append(c)
    }
    println(s)
    println()

    println("*".repeat(50))

    // 2. Lambda with Receiver VS Regular Lambda
    println("2. Lambda with Receiver VS Regular Lambda")

    val isEven: (Int) -> Boolean = { it % 2 == 0} // Regular Lambda
    val isOdd: Int.() -> Boolean = { this % 2 == 1 } // Lambda with Receiver

    println(isEven(2)) // Calling a Regular Lambda
    println(2.isOdd()) // Calling Lambda with Receiver (like extension functions)
}
