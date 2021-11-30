package `500_neat_features`

// We can call a map in Kotlin as we call normal arrays with `map[key]` syntax.
// Under-the-hood, this will call map.get(key).
// Same for map[key] = x. It will call map.set(key, x).
// We can do the same for any object.
// We can have multiple parameters inside the brackets.

class FullName(var first: String, var middle: String, var last: String) {
    operator fun get(index: Int): String = when (index) {
        1 -> first
        2 -> middle
        3 -> last
        else -> toString()
    }

    operator fun set(index: Int, name: String) {
        when (index) {
            1 -> first = name
            2 -> middle = name
            3 -> last = name
        }
    }

    override fun toString(): String {
        return "Full Name:  $first $middle $last"
    }
}

fun main() {
    val name = FullName("Rula", "Ahmad", "Odeh")
    println("name -> $name")
    println("name[1] -> ${name[1]}")
    println("name[2] -> ${name[2]}")
    println("name[3] -> ${name[3]}")
    println("name[4] -> ${name[4]}")
    println("*".repeat(50))

    name[2] = "Ali"
    println("name -> $name")
    println("name[1] -> ${name[1]}")
    println("name[2] -> ${name[2]}")
    println("name[3] -> ${name[3]}")
    println("name[4] -> ${name[4]}")
}
