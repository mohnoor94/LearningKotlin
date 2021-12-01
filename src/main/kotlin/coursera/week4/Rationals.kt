package coursera.week4

import java.math.BigInteger

// my solution for the fourth week problem: Rationals
// https://www.coursera.org/learn/kotlin-for-java-developers/programming/FNjea/rationals/instructions
class Rational : Comparable<Rational> {
    val numerator: BigInteger
    val denominator: BigInteger

    constructor(numerator: BigInteger, denominator: BigInteger) {
        require(denominator != BigInteger.ZERO) { "Denominator cannot be zero!" }
        // if (denominator == "0".toBigInteger()) throw IllegalArgumentException()

        val sign = denominator.signum().toBigInteger()
        val gcd = numerator.gcd(denominator)

        this.numerator = numerator / gcd * sign
        this.denominator = denominator / gcd * sign
    }

    constructor(n: Int, d: Int) : this(n.toBigInteger(), d.toBigInteger())

    operator fun plus(that: Rational): Rational {
        val n = this.numerator * that.denominator + this.denominator * that.numerator
        val d = this.denominator * that.denominator
        return Rational(n, d)
    }

    operator fun minus(that: Rational): Rational = plus(-that)

    operator fun times(that: Rational): Rational {
        return Rational(this.numerator * that.numerator, this.denominator * that.denominator)
    }

    operator fun div(that: Rational): Rational = times(Rational(that.denominator, that.numerator))

    override operator fun compareTo(that: Rational): Int {
        if (this.denominator == that.denominator) return this.numerator.compareTo(that.numerator)
        return (this.numerator * that.denominator).compareTo(that.numerator * this.denominator)
    }

    operator fun unaryMinus(): Rational = Rational(-this.numerator, this.denominator)

    // Automatically created because we implemented Comparable
//    operator fun rangeTo(end: Rational): RationalRange {
//        return RationalRange(this, end)
//    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (numerator != other.numerator) return false
        if (denominator != other.denominator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }

    override fun toString(): String {
        if (denominator == "1".toBigInteger()) return "$numerator"
        return "$numerator/$denominator"
    }
}

//class RationalRange(private val start: Rational, private val end: Rational) {
//    operator fun contains(value: Rational): Boolean = start <= value && value <= end
//}

infix fun Int.divBy(denominator: Int) = Rational(this, denominator)
infix fun BigInteger.divBy(denominator: BigInteger) = Rational(this, denominator)
infix fun Long.divBy(denominator: Long) = Rational(this.toBigInteger(), denominator.toBigInteger())

fun String.toRational(): Rational {
    if ("/" in this) {
//        val values = this.split("/")
//        return Rational(values[0].toBigInteger(), values[1].toBigInteger())

        val (n, d) = this.split("/")
        return Rational(n.toBigInteger(), d.toBigInteger())
    }
    return Rational(this.toBigInteger(), BigInteger.ONE)
}

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)
    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}