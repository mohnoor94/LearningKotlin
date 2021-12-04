package `110_lambda_with_receiver`

fun main() {
    data class Window(val width: Int, val height: Int)


    println("1. `with`")
    val window = Window(10, 20)
    with(window) {
        println(this)
        println(height)
        println(width)
        // ...
    }

    println("*".repeat(50))

    println("2. `run`")
    // like `with` but it's defined as an extension, which make it possible to be used with nullable types.

    window.run {
        println(this)
        println(height)
        println(width)
    }

    // but also ...

    @Suppress("RedundantNullableReturnType")
    val windowOrNull: Window? = Window(10, 15)

    windowOrNull?.run {
        println(height)
        println(width)
    }

    println("*".repeat(50))

    println("3. `apply`")
    // returns the receiver as a result

    val window1: Window = window.apply {
        println(this)
        println(height)
        println(width)
    } ?: return

    println("*".repeat(50))

    println("4. `also`")
    // regular argument instead of `this`

    window.apply { // lambda with receiver
        println(this)
        println(width)
        println(height)
    }.also {
        println(it) // regular lambda
    }
}
