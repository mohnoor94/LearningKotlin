package `080_object_oriented`

// special object inside a class
// like a static field in Java

class SomeClass {
    companion object { // can implement an interface and override some members - static in Java cannot do this.
        fun foo() = 1

        @JvmStatic
        fun bar() = 2
    }
}

// Define an extension for a companion object - use "Companion":
fun SomeClass.Companion.doSomething(param: String): SomeClass {
    println(param)
    return SomeClass()
}

fun main() {
    println(SomeClass.foo())
    // from Java:
    // SomeClass.Companion.foo()
    // or (With the @JvmStatic annotation):
    // SomeClass.Companion.bar()
    // SomeClass.bar()

    SomeClass.doSomething("ummm")

    // There are no `static` in Kotlin, but we can use these things/methods instead:
    // 1. Define something ar the top-level (directly inside the file, not a class). (Preferred).
    // 2. Inside objects. (If there is a private field inside a class that you want to use, for example).
}

class X {
    object A // OK
    // inner object B // Modifier 'inner' is not applicable to 'object - because it's a singleton and X is not.
}