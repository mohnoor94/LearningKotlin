package `080_object_oriented`

import java.lang.Exception

fun main() {
    class A

    val a = A() // Default constructor call

    class Person(val name: String, val age: Int) // primary constructor for the class
    // val or val inside the primary constructor will automatically create properties for them.

    val person = Person("Noor", 27)

    class Degree(value: Int) { // no val or var --> no property generated for the value field.
        init { // any initialization code to be in the constructor
            if (value < 0) throw Exception("Degree cannot be negative.")
        }
    }

    // val negativeDegree = Degree(-5) // java.lang.Exception: Degree cannot be negative.
    val positiveDegree = Degree(5)
    println(positiveDegree) // 080_object_oriented.Degree@xyz... (the object reference)

    // To change the visibility of the constructor:
    class InternalComponent
    internal constructor(name: String) {
        // ...
    }

    // Secondary Constructors
    class Rectangle(val height: Int, val width: Int) {
        // every secondary constructor must call another secondary or primary constructor
        constructor(side: Int): this(side, side) {
            // ...
        }
    }

    // default constructor is only generated when there are no other constructors declared.
}

