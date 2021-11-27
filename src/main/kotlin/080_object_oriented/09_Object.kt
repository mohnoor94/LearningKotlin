package `080_object_oriented`

// object = singleton

// To use an object from Java, call it from an INSTANCE static method from the class name: ClassA.INSTANCE.foo();
// From Kotlin, call it like any other object. But you will have only one object of its kind.

object Connection {
    const val address: String = "abc"
}

fun main() {
    println(Connection)
    println(Connection.address)
}