package `040_extension_functions`

// functions extends classes!

// Attach a new method to a current class - even built-in classes!

// Call methods in a nicer way (than Java).

// You cannot define an extension and use it everywhere. You have to import it explicitly (for different packages).

// You can call extension functions from Java as static functions in classes same as the file names (.kt) as we
// discussed before (just like a top-level function), and we call it there by name only.

// Extension functions are static functions defined in a special class - everything applicable to static methods in
// Java are applicable here as well.
// You cannot access the private members of a class in an extension (because it is actually a static method in a
// different class, you got me?)

fun main() {
    // Attach a method "lastChar" to the "String" class:

    //    fun String.lastChar() = this.get(this.length - 1)
    fun String.lastChar() = this[this.length - 1]
    println("abc".lastChar())


    // we can omit the "this" keyword
    fun String.lastChar2() = get(length - 1)
    println("abc".lastChar2())
}