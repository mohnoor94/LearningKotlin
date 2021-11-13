package `030_control_structures`

fun main() {
    // `in` can be used in 2 cases in Kotlin
    // 1. iteration (for element in range/collection)
    // 2. check for belonging (if element in range/collection)


    // in

    /** check if c is a letter **/
    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

    println("isLetter('a') => ${isLetter('a')}")
    println("isLetter('*') => ${isLetter('*')}")
    println()

    // not in

    /** check if c is not a digit **/
    fun isNotDigit(c: Char) = c !in '0'..'9'
    println("isNotDigit('x') => ${isNotDigit('x')}")
    println("isNotDigit('5') => ${isNotDigit('5')}")
    println()


    // in as when-condition

    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know... :("
    }

    println("recognize('a') => ${recognize('a')}")
    println("recognize('9') => ${recognize('9')}")
    println("recognize('*') => ${recognize('*')}")
    println()

    // `in` as `contains`
    println("Kotlin" in setOf("Java", "Scala"))

    // `in` in ranges
    println("Kotlin" in "Java".."Scala") // "Kotlin" <= "Java" && "Kotlin" >= "Scala"
}