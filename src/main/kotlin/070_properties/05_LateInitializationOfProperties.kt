package `070_properties`

class SomeClass {
    lateinit var whyRush: String
    // 1. It has to be a `var` and not a `val` - it's needed to be changed!
    // 2. It cannot be primitive - primitives cannot be initialized to null under the hood!
    // 3. Cannot be nullable - let's focus on what matters :p

    fun initClassPlease() { // any method
        println("Is `whyRush` initialized? --> ${this::whyRush.isInitialized}") // false
        whyRush = "oh.. let's work"
        println("Is `whyRush` initialized now? --> ${this::whyRush.isInitialized}") // true
    }
}


fun main() {
    val someObject = SomeClass()
    // println("someObject.whyRush --> ${someObject.whyRush}")
    // ERROR: UninitializedPropertyAccessException: lateinit property whyRush has not been initialized
    someObject.initClassPlease()
    println("someObject.whyRush --> ${someObject.whyRush}")
    println()
    println("someObject.whyRush --> ${someObject.whyRush}")
}