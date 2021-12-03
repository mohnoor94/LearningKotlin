package `100_sequences`

fun main() {
    // These functions are available for collections and sequences.
    // This just to make sure you know alternative ways of doing some calculations.

    class Person(val age: Int, val isGraduated: Boolean = false) {
        override fun toString() = "P($age${if (isGraduated) "G" else "-"})"
    }

    val people = listOf(
        Person(25, true),
        Person(30, true),
        Person(30),
        Person(10),
        Person(12),
        Person(40, true)
    )

    println(">> count = filter + size:")
    println(people.filter { it.age > 21 }.size) // 4
    println(people.count { it.age > 21 }) // 4 <-- same operation with one function.

    println("*".repeat(50))

    println(">> sortedByDescending = sortedBy + reversed:")
    println(people.sortedBy { it.age }.reversed()) // [P(40G), P(30-), P(30G), P(25G), P(12-), P(10-)]
    println(people.sortedByDescending { it.age }) // [P(40G), P(30-), P(30G), P(25G), P(12-), P(10-)]

    println("*".repeat(50))

    val peopleOrNot = listOf(
        Person(30, true),
        Person(10),
        Person(12),
        null,
        Person(40, true)
    )

    println(">> mapNotNull = map + filterNotNull:")
    println(
        peopleOrNot.map { p -> p.takeIf { p?.isGraduated ?: false }?.age }
            .filterNotNull()
    ) // [30, 40]

    println(peopleOrNot.mapNotNull { p -> p.takeIf { p?.isGraduated ?: false }?.age }) // [30, 40]

    println(peopleOrNot.filterNotNull().map { p -> p.takeIf { p.isGraduated }?.age ?: "N/A" }) // [30, N/A, N/A,40]


    println("*".repeat(50))
    println(">> map.getOrPut:")

    val map1 = mutableMapOf<Int, MutableList<Person>>()
    val map2 = mutableMapOf<Int, MutableList<Person>>()

    for (person in people) {
        /* Start */
        if (person.age !in map1) {
            map1[person.age] = mutableListOf()
        }
        val group = map1.getValue(person.age)
        /* End */
        group += person
    }

    // We can replace the code from "Start" to "End" with `getOrPut` function.
    for (person in people) {
        // if value is there, get it, or else put this as a value and get it as well.
        val group = map2.getOrPut(person.age) { mutableListOf() }
        group += person
    }

    println(map1) // {25=[P(25G)], 30=[P(30G), P(30-)], 10=[P(10-)], 12=[P(12-)], 40=[P(40G)]}
    println(map2) // {25=[P(25G)], 30=[P(30G), P(30-)], 10=[P(10-)], 12=[P(12-)], 40=[P(40G)]}

    println("*".repeat(50))
    println(">> groupBy:")
    // or better, we can replace all the logic above with:
    val peopleByAges: Map<Int, List<Person>> = people.groupBy { it.age } // Note that the types are immutable here
    println(peopleByAges) // {25=[P(25G)], 30=[P(30G), P(30-)], 10=[P(10-)], 12=[P(12-)], 40=[P(40G)]}

    println("*".repeat(50))
    println(">> groupingBy:")
    // groupBy is always eager <<in collections and sequences!>>
    // groupingBy is always lazy.

    val peopleByAgeCounts1: Map<Int, Int> = people
        .groupBy { it.age }
        .mapValues { (_, group) -> group.size }

    val peopleByAgeCounts2: Map<Int, Int> = people
        .groupingBy { it.age }
        .eachCount()

    println(peopleByAgeCounts1) // {25=1, 30=2, 10=1, 12=1, 40=1}
    println(peopleByAgeCounts2) // {25=1, 30=2, 10=1, 12=1, 40=1}

}
