package coursera.week2

// my (functional) solution for the second week problem.
// https://www.coursera.org/learn/kotlin-for-java-developers/programming/vmwVT/mastermind-game

import kotlin.math.min

fun evaluateGuess2(secret: String, guess: String): Evaluation {
    val rightPositions: Int = secret.zip(guess).count { it.first == it.second }
    val commonLetters: Int = "ABCDEF".sumOf { ch -> min(secret.count { ch == it }, guess.count { ch == it }) }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}
