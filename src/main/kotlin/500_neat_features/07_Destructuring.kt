package `500_neat_features`

// how can we do something like:
// val (first, second) = pairOfValues
// note that we always need the parentheses in this case.
// Same idea used when we can iterate over elements with their values in `list.withIndex()`.

class Name(private val first: String, private val last: String) {
    operator fun component1(): String = first
    operator fun component2(): String = last
    operator fun component3(): String = toString()
    // ...

    override fun toString(): String = "$first $last"
}

data class DataName(val first: String, val last: String)

fun main() {
    val name = Name("Rula", "Odeh")
    println(name) // Rula Odeh

    val (firstName, lastName, fullName) = name
    println(firstName) // Rula
    println(lastName) // Odeh
    println(fullName) // Rula Odeh

    // no need to use all the components
    val (fName, lName) = name
    println(fName) // Rula
    println(lName) // Odeh

    // we can even use certain components only
    val (_, _, fullName2) = name
    println(fullName2) // Rula Odeh

    println("*".repeat(50))

    // Data classes automatically generate a component for each property.
    val dataName = DataName("Rula", "Odeh")
    val (firstData, lastData) = dataName
    val (firstData2, _) = dataName
    val (firstData3) = dataName
    val (_, lastData2) = dataName

    println(dataName) // DataName(first=Rula, last=Odeh)
    println(firstData) // Rula
    println(firstData2) // Rula
    println(firstData3) // Rula
    println(lastData) // Odeh
    println(lastData2) // Odeh
}
