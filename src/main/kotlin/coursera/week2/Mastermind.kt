package coursera.week2

// my solution for the second week problem.
// https://www.coursera.org/learn/kotlin-for-java-developers/programming/vmwVT/mastermind-game

import kotlin.math.min

fun buildFrequencyTable(str: String): HashMap<Char, Int> {
    val table = HashMap<Char, Int>()
    for (ch in str) table[ch] = table.getOrDefault(ch, 0) + 1
    return table
}

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var right = 0
    for ((index, ch) in guess.withIndex()) if (secret[index] == ch) right++

    val secretFreqs = buildFrequencyTable(secret)
    val guessFreqs = buildFrequencyTable(guess)
    val allFreqs = HashMap<Char, Pair<Int, Int>>()
    val summary = HashMap<Char, Int>()

    for ((k, v) in secretFreqs) allFreqs[k] = (v to guessFreqs.getOrDefault(k, 0))

    for ((k, v) in allFreqs) summary[k] = min(v.first, v.second)

    val all = summary.values.sum()

    return Evaluation(right, all - right)
}
