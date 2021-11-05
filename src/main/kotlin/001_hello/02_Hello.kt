package `001_hello`

// You can have the arguments (args) in case they are needed
fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "Kotlin" // if is an expression, not a statement
    println("Hello, $name")

    println("Hello, ${args.getOrNull(0)}!")
}