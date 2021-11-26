package `080_object_oriented`

import `080_object_oriented`.Color.*

// enum is a modifier to a class - not a different construct of the language

enum class Color {
    RED,
    GREEN,
    BLUE
}

fun getDescription(color: Color) = when (color) {
//    Color.RED -> "hot"
    RED -> "hot" // we imported the enum above, we may use it directly
    GREEN -> "mild"
    BLUE -> "cold"
}

// You may define members and properties inside the enum!

enum class CustomColor(private val r: Int, private val g: Int, private val b: Int) {
    BLUE(0, 0, 255),
    ORANGE(255, 165, 0),
    RED(255, 0, 0); // we need the semicolon here.

    fun rgb() = (r * 256 + g) * 256 + b
}