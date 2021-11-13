package `020_basics`

fun main() {
    // Named and default parameters

    // specify 3 parameters (and easy to read and remember)
    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")")) // (abc)

    println(listOf('a', 'b', 'c').joinToString(separator = ", ")) // a, b, c

    println(
        listOf('a', 'b', 'c').joinToString(
            prefix = "(",
            postfix = ")"
        )
    ) // (a, b, c) - ", " is the default separator


    println("==================")
    displaySeparator('*', 10) // **********
    println()

    displaySeparator('*', 1) // *
    println()

    displaySeparator(character = '*', size = 5) // *****
    println()

    displaySeparator('*', size = 15) // ***************
    println()

    // This feature is replacing the functions overloading in Java. BUT
    // To call a function with default values from Java, you need to provide all parameters (as Kotlin only generate
    // one function implementation under-the-hood). To generate all possible overloaded functions you need to use
    // the @JvmOverloads annotation above the function.
    // Why? All possible functions are 2^n as n is the number of parameters - no need for all of this shit!
    // With @JvmOverloads, for a function with 3 parameters, 4 overloaded functions will be generated,
    // (all, first 2, first 1, none).
}

// size has a default value of 1
fun displaySeparator(character: Char, size: Int = 1) {
    repeat(size) {
        print(character)
    }
}