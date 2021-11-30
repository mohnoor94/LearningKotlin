package `500_neat_features`
import `500_neat_features`.CustomRange

class RangeStart(val start: Int) {
    operator fun rangeTo(end: Int): CustomRange {
        return CustomRange(start, end)
    }
}

fun main() {
    for (i in 1..10) { // this will call the `rangeTo` function!
        print("$i, ")
    }
    println()
    println("*".repeat(50))

    // Custom Example
    val start = RangeStart(10)
    val customRange = start..20

    println(customRange)
    println(15 in customRange)
}
