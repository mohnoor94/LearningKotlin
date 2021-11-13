package `030_control_structures`

import java.io.IOException
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

// Very similar to Java
// BUT
// Kotlin does not differentiate between checked and unchecked exceptions

// In Kotlin:
// 1. You may or may not handle any exception
// 2. Your function does not need to specify which exceptions it can throw
// 3. You can assign the value of the exception to a var/val.

fun main() {
    val number = 100 // try 1000

    val percentage =
        if (number in 0..100) number
    else
        throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")

    println(percentage)

    // try is an expression

    val num = try {
        Integer.parseInt("3d") // try a letter
    } catch (e: NumberFormatException) {
        null // or "return" to return a Unit
    }

    println(num)

    // @Throws is needed only if we want to call this code from Java - otherwise it won't compile.
    // It's not needed if we are working with Kotlin code base only.
    // This is because "IOException" is a checked exception in Java.
    @Throws(IOException::class)
    fun bar() {
        throw IOException()
    }
}