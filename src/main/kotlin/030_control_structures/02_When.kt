package `030_control_structures`

import java.awt.Color
import java.awt.Color.*
import java.lang.Exception

fun main() {

}

fun getDescription(color: Color): String =
    // when is similar to switch in Java, but can do much more
    // no 'break' is needed
    when (color) {
        BLUE -> "cold"
        ORANGE -> "mild"
        RED -> "hot"
        else -> "idk!"
    }

// list multiple values with same response
fun respondToInput(input: String) = when (input) {
    "y", "yes" -> "I'm glad you agree"
    "n", "no" -> "Sorry to hear that"
    else -> "wtf buddy, enter 'yes' or 'no'!"
}

// any expression can be used as a branch condition
fun mix(c1: Color, c2: Color) {
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        else -> throw Exception("Dirty color")
    }
}

// Checking types

open class Pet
class Dog: Pet() {
    fun woof() {}
}
class Cat: Pet() {
    fun meow() {}
}

fun talk(pet: Pet) {
    when(pet) {
        is Cat -> pet.meow() // already converted to "Cat" (is = instanceOf + smart casting)
        is Dog -> pet.woof() // already converted to "Dog"
    }
}

// when without arguments --> use boolean expressions inside
fun updateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 5 -> "cold" to BLUE // x to y = Pair(x, y)
        degrees < 23 -> "mild" to ORANGE
        else -> "hot" to RED
    }
}