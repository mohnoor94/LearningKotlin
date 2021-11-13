@file:Suppress("ReplaceGetOrSet")

package `040_extension_functions`


open class Parent
class Child : Parent()

fun Parent.foo() = "parent"
fun Child.foo() = "child"

fun main() {
    val parentChild: Parent = Child()
    val child = Child() // type is Child
    println(parentChild.foo()) // "parent" - Java uses the declared type to choose the correct static function
    println(child.foo()) // "child" - the declared type is also a "Child"
    println()
    println("==========")
    println()

    // Extensions are static Java functions under the hood
    // NO override for extension functions in Kotlin

    fun String.get(index: Int): Char = '*' // will be shadowed by the member method in the String class
    println("abc".get(1))

    // but we can overload a method
    fun String.get(start: Int, end: Int): String = this.substring(start, end)
    println("abcde".get(1, 4))
}