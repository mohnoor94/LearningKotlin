package `120_types`

fun main() {
    // There is no primitive types in Kotlin
    // but under-the-hood, the compiler will convert them to primitive Java types.
    val a: Int = 1
    val b: Int? = 2 // could be null - nullable

    // Int --> int
    // Double --> double
    // Boolean --> boolean

    // Int? --> java.lang.Integer
    // Double? --> java.lang.Double
    // Boolean? --> java.lang.Boolean

    // Generic & Arrays Arguments:
    // List<Int> --> List<java.lang.Integer>
    // Array[Int] --> Integer[]
    // intArray --> int[]

    // String:
    // kotlin.Sting --> java.lang.String
    // Kotlin uses the Java String type but add (and remove) some methods inside.


    // Any --> java.lang.Object
    // Any in Kotlin is supertype to all other types including Int, Double & Booleans (the replacements of the primitives).

    // Function Types:
    // () -> Boolean        --> Function0<Boolean> or a lambda
    // (Order) -> Int       --> Function1<Order, Int>
    // (Int, Int) -> Int    --> Function2<Int, Int, Int>
    // ...

}
