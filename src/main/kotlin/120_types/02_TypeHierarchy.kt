package `120_types`

fun main() {

    // `Any` is the super type of all types.
    // `Nothing` is a subtype of all the types.

    // `Unit` in Kotlin = `void` in Java:
    // - No meaningful value is returned.

    // these 2 functions will return a `Unit`
    // the function complete normally.
    fun f1() {}
    fun f2(): Unit {}


    // `Nothing` means that the function is NEVER returned!
    // Or always complete abnormally - an exception is thrown.
    fun fail(message: String): Nothing {
        throw IllegalStateException(message)
    }

//    fun infiniteLoop(): Nothing {
//        while (true) { }
//    }

    // `Unit`: A type that allows only one value and thus can hold no information.
    // `Nothing`: A type that has no values.

    // You can use the `Nothing` type wherever you may throw an exception.

    fun timeHasPassed(): Boolean = false
//    val answer : Int = if(timeHasPassed()) {
//        500
//    } else {
//        fail("No answer yet...")
//    }
//    println(answer) // java.lang.IllegalStateException: No answer yet...

    // TODO() // is a function defined using the `Nothing` type.

    println("*".repeat(25))

    data class Person(val name: String?)

    fun greetPerson(person: Person) {
        //val name: String = person.name ?: throw IllegalStateException("Name is not specified")
        val name: String = person.name ?: fail("Name is not specified")
        // val name: String = person.name ?: return // return with no error - do NOTHING
        println("Hello $name")
    }

    greetPerson(Person("Alix")) // Hello Alix
    // greetPerson(Person(null)) // java.lang.IllegalStateException: Name is not specified

    // In Java (JVM) the Nothing functions are also converted to void functions as we don't have the `Nothing` type
    // in the JVM - but we have it in Kotlin!

    // =====

    // Every type is a subtype of a similar nullable type as well.
    // Any is a subtype of Any?
    // Int is a subtype if Int?
    // Double is a subtype if Double?
    // Nothing is a subtype if Nothing? (`null` is of type Nothing?)
}
