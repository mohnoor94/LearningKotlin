package `070_properties`

// read-only extension properties
val String.lastIndex: Int // (without parentheses -> property. With parentheses -> function)
    get() = length - 1

val String.indices: IntRange
    get() = 0..lastIndex

// mutable extension properties
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        setCharAt(length - 1, value)
    }

fun main() {
    println("abc".lastIndex)
    println("abc".indices)

    println("=".repeat(20))

    val sb = StringBuilder("Kotlin?")
    println("sb -> $sb")
    sb.lastChar = '!'
    println("sb -> $sb")
}
