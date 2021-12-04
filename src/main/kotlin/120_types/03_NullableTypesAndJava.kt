package `120_types`

import AnnotatedSession
import Session

// Nullable types and how to work with Java types from Kotlin.
fun main() {
    val session = Session()
    val description = session.description // the inferred type is String! (an annotation, not a real type)
    // String!: A platform type String - we don't know if it is nullable or not!
    // How to behave? Compiler won't check, either the code will work, or it will throw a NPE.
    // Just like Java.

    // println(description.length) // java.lang.NullPointerException
    println(description?.length) // null

    println("*".repeat(50))

    // How to solve that? 2 solutions:
    // 1. Annotate your Java code with @Nullable and @NotNull and Kotlin will infer the correct types.

    val annotatedSession = AnnotatedSession()
    val annotatedDescription: String? = annotatedSession.description // the inferred type is String?
    //println(annotatedDescription.length) // won't work as the type is nullable :D
    println(annotatedDescription?.length) // null - works with the safe access like any Kotlin nullable type :D

    println("*".repeat(50))

    // 2. Specify types explicitly
    // If the Java code is an external dependency for example.
    val description2: String? = session.description
    // println(description2.length) // cannot work with nullable types.
    println(description2?.length)


    // What if we make it explicit that the code is not nullable, but it's actually null?

    //  val description3: String = session.description // java.lang.NullPointerException: session3.description must not be null

    // The NPE is thrown on the previous statement itself. So I commented it.
}