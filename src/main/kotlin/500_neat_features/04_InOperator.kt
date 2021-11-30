package `500_neat_features`

// To check if an element in a collection or any object.
// We can call `in` on any object by defining the `contains` function as operator.

class CustomRange(val start: Int, val end: Int) {
    operator fun contains(number: Int): Boolean {
        return (number > start) && (number <= end)
    }
}

fun main() {
    println(1 in CustomRange(0, 5))
    println(10 in CustomRange(0, 5))
}
