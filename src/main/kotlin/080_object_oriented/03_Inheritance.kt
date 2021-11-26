package `080_object_oriented`

interface Base

fun main() {
    class BaseImp: Base // implements `Base` interface

    open class Parent // must be open so that we can extend it
    class Child: Parent() // must extend a parent constructor - not only the parent class name.


    open class NamedParent(val name: String)
    class NamedChild(name: String): NamedParent(name) // ewww...
    // or...
    class AnotherNamedChild: NamedParent {
        constructor(name: String, someOtherParam: Int): super(name) // ewww too...
    }

    open class AnotherParent {
        init { print("parent ") }
    }

    class AnotherChild: AnotherParent() {
        init { print("child ") }
    }

    val anotherChild = AnotherChild() // parent child
    // the parent init & constructor are called before the ones in the child class - obviously.

    println("*".repeat(20))

    open class FourthParent {
        open val foo = 1
        init {
            println(foo)
        }
    }

    class FourthChild: FourthParent() {
        override val foo = 2
    }

    val fourthChild = FourthChild() // 0
    // override will override a getter not a field (we cannot override fields neither in Java nor in Kotlin).
    // we will call the overridden getter from the child, which will return a field that is not yet initilized, so
    // the default value of the integer is returned... meh.
}