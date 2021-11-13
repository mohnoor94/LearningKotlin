package `020_basics`

// var: mutable (can be modified)
// val: read-only (final / cannot be modified)

fun main() {
    val hello = "hello"
    println(hello)

    // hello = "hi"  // Error: Val cannot be reassigned


    // // the type could be automatically inferred by Kotlin (Explicitly given type is redundant here)
    var hi: String = "hi"
    var number: Int = 0

    hi = "hello" // it's a var, you can reassign a new value.
}