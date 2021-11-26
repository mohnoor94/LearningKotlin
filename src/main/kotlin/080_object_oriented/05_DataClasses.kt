package `080_object_oriented`

import org.jetbrains.annotations.Contract

// `data` is another class modifier in Kotlin
// data classes generates:
// - equals (==)
// - hashcode
// - copy (deep copy and override some arguments by their names)
// - toString
// ... and some others

data class Contact(val name: String, val address: String)

fun main() {
    val firstContact = Contact("Noor", "Amman")
    val secondContact = firstContact.copy(address = "Berlin")

    println(firstContact) // Contact(name=Noor, address=Amman)
    println(secondContact) // Contact(name=Noor, address=Berlin)

    println("*".repeat(20))

    // Check for equality:
    // == values equality (calls equals method)
    // === reference equality

    val set1 = setOf(1, 2, 3)
    val set2 = setOf(1, 2, 3)

    println(set1 == set2) // true // values are equal (because equals method is defined in the data class).
    println(set1 === set2) // false // references are different

    // equals in data classes are generated based on the values on the primary constructor only. not anything else.

}
