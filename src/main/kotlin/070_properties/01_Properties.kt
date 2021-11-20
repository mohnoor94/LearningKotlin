package `070_properties`

fun main() {
    // a field with its setter and getter is called a property.
    // In Java, you have to define these setters and getters as separate methods.

    // In Kotlin, it's defined for you.
    // Read-only properties: val
    // Mutable properties: var

    // instead of object.getXxx() --> object.xxx (like a normal variable).
    // instead of object.setXxx(value) --> object.xxx = value (like a normal variable).

    // If you are calling these methods from Java, you can call them the Java way getXxx() and setXxx(...).
    // If you are calling a Java getters and setters from Kotlin, you should call them the Kotlin way!

    class Person(val name: String, var age: Int)
    // This will generate these methods under the hood:
    // getName (it's a val) (@NotNull)
    // getAge & setAge (it's a var)

    // We can define properties without fields
    // In Java we can define setters and/or getters without actual fields. In Kotlin:

    class Rectangle(val height: Int, val width: Int) {
        val isSquare: Boolean
            get() { // getter
                return height == width
            }
    }

    val rectangle = Rectangle(2, 3)
    println(rectangle.isSquare) // false

    println()
    println("=".repeat(20))

    val foo1 = run {
        println("Calculating the lambda value...")
        42
    }

    println("foo1 -> $foo1")
    println("foo1 -> $foo1")

    // lambda is calculated once and then the value is stored,
    // that's why "Calculating the lambda value..." is printed only once.

    println()
    println("=".repeat(20))

    class Foo2Class {
        val foo2: Int
            get() {
                println("Calculating the getter value...")
                return 42
            }
    }

    val fooObject = Foo2Class()
    println("fooObject.foo2 -> ${fooObject.foo2}")
    println("fooObject.foo2 -> ${fooObject.foo2}")

    // The getter will be called everytime.
    // That's why "Calculating the getter value..." is printed twice.

    println()
    println("=".repeat(20))

    // You can access the field inside its getter and setter only using the special keyword `field`.
    // It's not visible to other methods even inside the same class.
    // Note: No fields defined if you wrote accessors (getters and setters) without accessing the field inside them.
    class StateLogger {
        var state = false
            set(value) {
                println("state has changed: $field -> $value")
                field = value
            }
    }

    val stateLogger = StateLogger()
    stateLogger.state = true
    stateLogger.state = true
    stateLogger.state = false

    println()
    println("=".repeat(20))

    // If you don't define accessors, the compiler will generate the default ones for you.

    class A {
        val readOnlyField: String = "readOnlyField"
        var mutableField: String = "mutableField"
    }

    val a = A()
    println("a.readOnlyField -> ${a.readOnlyField}")
    //a.readOnlyField = // error - val
    println("a.mutableField -> ${a.mutableField}")
    a.mutableField = "new value" // no problem - var
    println("a.mutableField -> ${a.mutableField}")

    println()
    println("=".repeat(20))

    // You can change the visibility of the accessors.
    class B {
        var value: Int = 0
            private set // no need to change the implementation (if we don't want to)

        fun increaseValue() {
            value++
        }
    }

    val b = B()
    println("b.value -> ${b.value}")
    // b.value = 10 // error - setters is private
    b.increaseValue()
    println("b.value -> ${b.value}")
}
