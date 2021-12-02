package `090_inline_functions`

import java.io.BufferedReader
import java.io.FileReader

fun main() {
    fun myRun(f: () -> Unit) = f() // doing the same as the built-in `run` function
    // but, everytime we call this `myRun` function, there is an object of a class created under-the-hood to execute the
    // lambda function! Which could be very critical performance-wise.

    // inline function:
    // compiler substitutes a body of the function instead of calling it
    // thus, it will add ZERO overhead!

    // To write an inline function. You cannot store the lambda anywhere, but you have to call it directly.

    // Another example is how `synchronized` in Java can be done in Kotlin. We can have instead:
    // val l: Lock = ...
    //l.withLock {
    //    // access the resource protected by this lock
    //}

    // Another example: `use` - which is similar to "try-with-resources" construct in Java.
    fun readFirstLineFromFile(path: String): String {
        BufferedReader(FileReader(path)).use { return it.readLine() }
    }

    // There is NO performance overhead when you use:
    // - run
    // - let
    // - takeIf
    // - takeUnless
    // - repeat
    // - withLock
    // - use
    // As no anonymous class or extra objects are created fir lambda under the hood.

    // From Java, inline functions are called the same way any other function will be called.
    // Java compiler knows nothing about `inline`.

    // @InlineOnly
    // Specifies that this function should not be called directly without inlining
    // Thus, it won't be added to the compiled file (as it will be only inlined when it's called).
    // This will save some space of the generated file.

    // Most probably, you won't need to inline your function.
    // If you needed to, use it with care.
}
