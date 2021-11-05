package `003_control_structures`

fun main() {
    // if is an expression in Kotlin - it returns a value
    // just like the ternary operator in Java ? :

    val a = 5
    val b = 10

    val max = if (a > b) a else b
    println("max between $a and $b is $max")
}