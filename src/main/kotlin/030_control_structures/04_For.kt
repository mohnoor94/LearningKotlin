package `030_control_structures`

fun main() {

    println("======== list ========")
    val list = listOf("a", "b", "c")

    for (s in list) { // like Python
        println(s)
    }

    println("======== map ========")
    val map = mapOf(
        1 to "One",
        2 to "Two",
        3 to "Three"
    )

    for ((key, value) in map) {
        println("* $key -> $value")
    }

    println("======== list with index ========")
    for ((index, element) in list.withIndex()) {
        println("* $index -> $element")
    }

    println("======== iterating over range ========")
    println("..")
    for (i in 1..9) {
        print("$i, ")
    } // 1..9
    println()

    println("until")
    for (i in 1 until 9) {
        print("$i, ")
    } // 1..8
    println()

    println("with step / downTo")
    for (i in 9 downTo 1 step 2) {
        print("$i, ")
    }
    println()

    println("======== iterating over a string ========")
    for (ch in "abcde") {
        print("${ch + 1}, ")
    }
    println()
}