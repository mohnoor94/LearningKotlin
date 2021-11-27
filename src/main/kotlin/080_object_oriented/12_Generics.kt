package `080_object_oriented`

import java.lang.Appendable

interface List<E> { // could have nullable elements
    fun get(index: Int): E
}

fun foo(ints: List<Int>) {
}

fun bar(strings: List<String>) {
}

// Generic Functions
fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T> {
    return this.filter(predicate) // really? what a hard implementation :p
}

fun use1(ints: List<Int>) {
    ints.filter { it > 0 }
}

fun use2(strings: List<String>) {
    strings.filter { it.isNotEmpty() }
}

fun use3(ints: List<Int?>) {
    ints.filter { it != null && it > 0 }
}

interface NotNullableList<E : Any> { // not nullable interface since E is extending a not nullable type: Any.
    fun get(index: Int): E
}

// 1 Constraint for the type:
interface NumbersList<E : Number>

// Multiple constraints for the type: use `where`
fun <T> ensureTrainlingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) seq.append('.')
}

// for JVM: List<Double> and List<Int> are both of the same type `List` so we cannot declare these at the same type:

//fun List<Int>.average(): Double = 0.5 // random value
//fun List<Double>.average(): Double = 1.5 // random value

// Platform declaration clash: The following declarations have the same JVM signature
// (average(L080_object_oriented/List;)D):

// But, we can apply the @JvmName annotation.

fun List<Int>.average(): Double = 0.5 // random value

@JvmName("averageOfDouble") // this is the name for Java.
fun List<Double>.average(): Double = 1.5 // random value
