package `050_nullability`

fun main() {
    val s1: String? = "Hello"

    // Java-like
    if (s1 is String) { // instanceOf
        val s2 = s1 as String // casting - (type cast) - automatically done in Kotlin
        println(s2.uppercase())
    }

    // Kotlin
    if (s1 is String) println(s1.uppercase()) // smart cast

    println(s1 as? Int) // null (safe cast) (null if failed)
    // println(s1 as Int) // null - exception (regular cast) (exception if failed)

    println(s1 as? String) // Hello (safe cast)
    println(s1 as String) // Hello (regular cast)

    println(s1) // Hello
}