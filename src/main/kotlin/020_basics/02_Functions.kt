package `020_basics`

fun main() {
    println("Max is ${max(10, 6)}")
    displayMax(20, 30)
}


// normal function
//fun max(a: Int, b: Int): Int {
//    return if (a > b) a else b
//}

// one liner function (expression body)
fun max(a: Int, b: Int): Int = if (a > b) a else b

fun displayMax(a: Int, b: Int) { // type is inferred to be Unit (like void in Java)
    println(max(a, b))
}