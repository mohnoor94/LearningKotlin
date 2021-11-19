@file:Suppress("RedundantNullableReturnType", "UNUSED_VARIABLE")

package `060_functional_programming`

fun main() {
    val double: (Int) -> Int = { it * 2 } // (Int) -> Int is the type of the lambda function
    val isEven: (Int) -> Boolean = { it % 2 == 0 } // (Int) -> Boolean is the type of the lambda function

    println(listOf(1, 2, 3, 4, 5, 6, 7).filter(isEven).map(double)) // pass function name

    // Nullable Lambdas
    val f1: () -> Int? = { null } // a function returns an int or a null
    val f2: () -> Int? = { 5 } // a function returns an int or an int

    val f3: (() -> Int)? = null // returns a (function that returns an int) or null
    val f4: (() -> Int)? = { 4 } // returns a (function that returns an int) or null

    // Calling a nullable function type
    // f4() // Error: Reference has a nullable type

    // check if not null
    if (f4 != null) {
        println(f4()) // smart-casted
    }

    // safe access syntax with "invoke" method
    println(f4?.invoke())
}