package coursera.week3

data class TaxiPark(
    val allDrivers: Set<Driver>,
    val allPassengers: Set<Passenger>,
    val trips: List<Trip>,
)

data class Driver(val name: String)
data class Passenger(val name: String)

data class Trip(
    val driver: Driver,
    val passengers: Set<Passenger>,
    // the trip duration in minutes
    val duration: Int,
    // the trip distance in km
    val distance: Double,
    // the percentage of discount (in 0.0..1.0 if not null)
    val discount: Double? = null,
) {
    // the total cost of the trip
    val cost: Double
        get() = (1 - (discount ?: 0.0)) * (duration + distance)
}

// my solutions for the third week problem: Taxi Park
// https://www.coursera.org/learn/kotlin-for-java-developers/programming/xTPZT/taxi-park

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    allDrivers.filter { driver -> trips.none { trip -> trip.driver == driver } }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    allPassengers.filter { passenger -> trips.count { trip -> passenger in trip.passengers } >= minTrips }.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    allPassengers.filter { passenger ->
        trips.count { trip -> trip.driver == driver && passenger in trip.passengers } > 1
    }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    trips
        .flatMap { trip -> trip.passengers.map { passenger -> passenger to trip.discount } }
        .groupBy { it.first }
        .filter { (_, discounts) ->
            val (discounted, notDiscounted) = discounts.partition { it.second != null }
            discounted.size > notDiscounted.size
        }
        .map { it.key }
        .toSet()


/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    val start = trips
        .groupBy { trip -> trip.duration / 10 }
        .maxByOrNull { it.value.size }?.key // maxBy for Coursera as they use an older version of Kotlin

    if (start != null) return (start * 10)..(start * 10 + 9)

    return null
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (trips.isEmpty()) return false

    val numberOfTopDrivers = allDrivers.size / 5
    val allIncome = trips.sumOf { it.cost } // sumByDouble for Coursera as they use an older version of Kotlin

    val incomePerDriver = trips.map { trip -> trip.driver to trip.cost }
        .groupBy { it.first }
        .map { (_, value) -> value.sumOf { it.second } }  // sumByDouble for Coursera as they use an older version of Kotlin
        .sortedDescending()

    return incomePerDriver.take(numberOfTopDrivers).sum() >= 0.8 * allIncome
}