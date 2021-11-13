package `040_extension_functions`

// Kotlin standard library is actually the Java standard library + a lot of extensions!

fun main() {
    val set = hashSetOf(1, 2, 3)
    println(set.javaClass) // class java.util.HashSet

    val list = arrayListOf(1, 3, 4)
    println(list.javaClass) // class java.util.ArrayList

    val map = hashMapOf(
        1 to "one",
        7 to "seven",
        53 to "fifty-three"
    )
    println(map.javaClass) // class java.util.HashMap


    println("=====================")

    // infix functions can be called as if they are operators
    // example: until.
    // could be called like 1.until(10) or 1 until 10

    infix fun Int.times(number: Int): Int = this * number
    println(5 times 10)
    println(5.times(10))
    println()

    // to is another extension functions written in an infix form.
    // 1 to "ONE" to create a pair of Pair(1, "ONE")

    // example:
    infix fun <T> T.eq(other: T): Boolean {
        return this == other
    }

    val x = 10
    println(10 eq 10)
    println(10 eq 100)
}