package `060_functional_programming`


fun main() {
    data class Employee(val name: String, val age: Int)

    val employees = listOf(
        Employee("Noor", 27),
        Employee("Ali", 30),
        Employee("Lama", 27),
        Employee("Lina", 35)
    )

    // filter: keep all elements that meet a criteria/predicate
    val thirtyPlus = employees.filter { it.age >= 30 }
    println("thirtyPlus -> $thirtyPlus") // [Employee(name=Ali, age=30), Employee(name=Lina, age=35)]
    println()

    // map: do an operation on all the elements
    val initials = employees.map { it.name[0] }
    println("initials -> $initials") // [N, A, L, L]
    println()

    // any: check if at least one element meet a criteria/predicate
    println("any > 32? -> ${employees.any { it.age > 32 }}") // true
    println()

    // all: check if all elements meet a criteria/predicate
    println("all > 32? -> ${employees.all { it.age > 32 }}") // false
    println("all > 22? -> ${employees.all { it.age > 22 }}") // true
    println()

    // none: check if none of the elements meet a criteria/predicate
    println("none > 32? -> ${employees.none { it.age > 32 }}") // false
    println("none > 42? -> ${employees.none { it.age > 42 }}") // true
    println()

    // find: check if at least one element meet a criteria/predicate and return it; null otherwise
    println("find > 32? -> ${employees.find { it.age > 32 }}") // Employee(name=Lina, age=35)
    println("find > 32? -> ${employees.find { it.age > 42 }}") // null
    println()

    // firstOrNull: same as find
    println("firstOrNull > 32? -> ${employees.firstOrNull { it.age > 32 }}") // Employee(name=Lina, age=35)
    println("firstOrNull > 32? -> ${employees.firstOrNull { it.age > 42 }}") // null
    println()

    // first: same as find, but it throws an exception if no element is found
    println("first > 32? -> ${employees.first { it.age > 32 }}") // Employee(name=Lina, age=35)

    // NoSuchElementException: Collection contains no element matching the predicate.
    // println("first > 32? -> ${employees.first { it.age > 42 }}")
    println()

    // count: counts the number of elements that meet a criteria/predicate
    println("count > 32? -> ${employees.count { it.age > 32 }}") // 1
    println("count > 22? -> ${employees.count { it.age > 22 }}") // 4
    println()

    // partition: divide the collection into 2 groups: the elements that meet the given criteria/predicate, and the
    // ones which not
    val (juniors: List<Employee>, seniors: List<Employee>) = employees.partition { it.age >= 30 }
    println("juniors -> $juniors") // [Employee(name=Ali, age=30), Employee(name=Lina, age=35)]
    println("seniors -> $seniors") // [Employee(name=Noor, age=27), Employee(name=Lama, age=27)]
    println()

    // groupBy: divide the collection into multiple groups based on a criteria
    // result is: map of: key (criteria) -> List (elements)
    val ageGroups: Map<Int, List<Employee>> = employees.groupBy { it.age }
    println("ages -> $ageGroups")
    // {
    // 27=[Employee(name=Noor, age=27), Employee(name=Lama, age=27)],
    // 30=[Employee(name=Ali, age=30)],
    // 35=[Employee(name=Lina, age=35)]
    // }
    println()

    // associateBy: similar to groupBy but the key is unique, so that the value is an element (not a list of elements)
    // If any two elements would have the same key, the last one gets added to the map (duplicates removed).
    println("employees.associateBy { it.age } -> ${employees.associateBy { it.age }}")
    // {
    // 27=Employee(name=Lama, age=27),
    // 30=Employee(name=Ali, age=30),
    // 35=Employee(name=Lina, age=35)
    // }

    println("employees.associateBy { it.name } -> ${employees.associateBy { it.name }}")
    // {
    // Noor=Employee(name=Noor, age=27),
    // Ali=Employee(name=Ali, age=30),
    // Lama=Employee(name=Lama, age=27),
    // Lina=Employee(name=Lina, age=35)
    // }
    println()

    // associate: build a map based on a list
    println("employees.associate { it.name to it.age } -> ${employees.associate { it.name to it.age }}")
    // {Noor=27, Ali=30, Lama=27, Lina=35}
    println()

    // zip: join 2 collections to a list of pairs
    // the length of the result is equal to the length of the shortest collection
    val nums = 1..10
    println("employees.zip(randomNumbers) -> ${nums.zip(employees)}")
    // [
    // (1, Employee(name=Noor, age=27)),
    // (2, Employee(name=Ali, age=30)),
    // (3, Employee(name=Lama, age=27)),
    // (4, Employee(name=Lina, age=35))
    // ]
    println()

    // zipWithNext: returns a list of pairs of each two adjacent elements in this collection.
    println("employees.zipWithNext() -> ${employees.zipWithNext()}")
    // [
    // (Employee(name=Noor, age=27), Employee(name=Ali, age=30)),
    // (Employee(name=Ali, age=30), Employee(name=Lama, age=27)),
    // (Employee(name=Lama, age=27), Employee(name=Lina, age=35))
    // ]
    println()

    val allEmployees: List<List<Employee>> = listOf(
        employees,
        listOf(
            Employee("Ola", 39),
            Employee("Basel", 25)
        )
    )

    println("allEmployees -> $allEmployees")
    // [
    //  [
    //      Employee(name=Noor, age=27),
    //      Employee(name=Ali, age=30),
    //      Employee(name=Lama, age=27), Employee(name=Lina, age=35)
    //  ],
    //  [
    //      Employee(name=Ola, age=39),
    //      Employee(name=Basel, age=25)
    //  ]
    // ]
    println()

    // flatten: returns a single list of all elements from all collections in the given collection
    println("allEmployees.flatten() -> ${allEmployees.flatten()}")
    // [
    // Employee(name=Noor, age=27),
    // Employee(name=Ali, age=30),
    // Employee(name=Lama, age=27),
    // Employee(name=Lina, age=35),
    // Employee(name=Ola, age=39),
    // Employee(name=Basel, age=25)
    // ]

    // flatMap:
    val allThirtyPlus = allEmployees.flatMap { it -> it.filter { it.age >= 30 } }
    println("allThirtyPlus -> $allThirtyPlus")
    // [
    // Employee(name=Ali, age=30),
    // Employee(name=Lina, age=35),
    // Employee(name=Ola, age=39)
    // ]
    println()


}
