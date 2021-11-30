package `500_neat_features`

// We can use the comparison operators to compare any object in Kotlin.

data class NumberDigit(val value: Int) : Comparable<NumberDigit> {
    override fun compareTo(other: NumberDigit): Int { // operator
        return this.value - other.value
    }
}

fun main() {
    val one = NumberDigit(1)
    val two = NumberDigit(2)

    println(one > two)
    println(one >= two)
    println(one < two)
    println(one <= two)
    println(one == two) // calls `equals`, and checks for null.
}
