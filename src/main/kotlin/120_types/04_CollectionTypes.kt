package `120_types`

fun main() {
    // We work with some Java collections under-the-hood

    val set = hashSetOf(1, 2, 9)
    println(set.javaClass) // class java.util.HashSet

    val list = arrayListOf(1, 2, 9)
    println(list.javaClass) // class java.util.ArrayList

    val map = hashMapOf(
        1 to "one",
        2 to "two",
        9 to "nine"
    )
    println(map.javaClass) // class java.util.HashMap

    // ===

    // In Java, we have: java.util.list
    // In Kotlin, we have: Kotlin.List & Kotlin.MutableList

    // List is an interface in Kotlin.
    // MutableList is also an interface in Kotlin which extends the List interface.

    // Both List and MutableList in Kotlin are replaced by the Java's List under-the-hood.

    // If we read a List<String> from Java in Kotlin, it will be (Mutable)List<String!> (notation, not syntax).

    // You have to specify if the list is mutable, otherwise, it will be immutable.
}