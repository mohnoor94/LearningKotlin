@file:Suppress("UNUSED_VARIABLE")

package `060_functional_programming`

fun main() {
    // You can save lambda in a variables
    // BUT, you cannot store a function in a variable >> as in the real functional programming languages...
    // I miss Scala now :(

    // Use the function reference (::) to save any function in a variable

    fun isEven(i: Int): Boolean = i % 2 == 0
    //val predicate = isEven // Error: Function invocation 'isEven(...)' expected
    val predicate = ::isEven // correct

    val predicateUnderTheHood = { i: Int -> isEven(i) } // that how will Kotlin understand the `predicate` above.
    // This is extra beneficial when you have more parameters, as we don't need to write all of them again.


    // Bound & Non-Bound References
    class Person(val name: String, val age: Int) {
        fun isOlder(ageLimit: Int) = age > ageLimit
    }

    // Non-Bound Reference: It can be used on any Person object - non-bound to a certain one.
    val agePredicate: (Person, ageLimit: Int) -> Boolean = Person::isOlder

    // Under the hood:
    val agePredicateUnderTheHood: (Person, ageLimit: Int) -> Boolean =
        { person, ageLimit -> person.isOlder(ageLimit) }

    val alice = Person("Alice", 29)
    println(agePredicate(alice, 25)) // true ... we call it with a Person object and an int for the ageLimit

    // Bound Reference: Bound to a certain object
    val aliceAgePredicate: (ageLimit: Int) -> Boolean = alice::isOlder

    // Under the hood:
    val aliceAgePredicateUnderTheHood: (ageLimit: Int) -> Boolean = { ageLimit -> alice.isOlder(ageLimit) }
    println(aliceAgePredicate(25)) // true ...
    // we call it with an int for the ageLimit ONLY, because we will always use the `alice` object.
}