package `070_properties`

fun main() {
    // Lazy property: a property which values are computed only on the fist success.
    // It's not competed unless it's needed.
    // after that it will be saved as a normal val.

    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }

    println(lazyValue)
    println(lazyValue)

    // computed! is printed only once - because we calculate the lazy value only once, when we need to.
}
