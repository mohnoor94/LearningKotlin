package `050_nullability`

// Modern approach:
// convert null pointer exceptions from run-time errors to compile-time errors.

fun main() {
    val s1: String = "always not null"
    //val s2: String = null // error: Null can not be a value of a non-null type String

    val s3: String? = null
    val s4: String? = "could be null" // warning: 's3' is always non-null type

    println("s1.length -> ${s1.length}")

    // Deal with nullability
    // 1. if
    if (s4 != null) {
        println("s4.length) -> ${s4.length}")
    }

    // 2. safe access expression
    println("s4?.length -> ${s4?.length}")
    println("s3?.length -> ${s3?.length}") // null

    val s3LengthNullable: Int? = s3?.length
    val s3Length: Int = s3?.length ?: 0 // elvis operator

    println("s3LengthNullable= $s3LengthNullable, s3Length= $s3Length")

    if (s4== null) return // if not null - you can use it safely below (Control-flow Analysis). WOW!
    println("s4.length (Control-flow Analysis applied) -> ${s4.length}")

    val s5: String? = "could be null, again"
    println("s5!!.length (AVOID THIS) -> ${s5!!.length}") // !! throw NPE if null - otherwise return value - AVOID THIS

    // println(s3!!.length) // java.lang.NullPointerException
}