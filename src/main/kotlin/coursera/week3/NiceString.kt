package coursera.week3

// my solution for the third week problem: Nice String
// https://www.coursera.org/learn/kotlin-for-java-developers/programming/hlugM/nice-string

// first solution:
fun String.isNice(): Boolean {
    val containsBees: (String) -> Boolean =
        { it.contains("bu") || it.contains("ba") || it.contains("be") }

    val isVowel: (Char) -> Boolean =
        { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' }

    val containsThreeVowels: (String) -> Boolean = { it.filter(isVowel).length >= 3 }

    val containsDoubleLetter: (String) -> Boolean = { str -> str.zipWithNext().any { (f, s) -> f == s } }

    return !containsBees(this) && containsThreeVowels(this)
            || !containsBees(this) && containsDoubleLetter(this)
            || containsThreeVowels(this) && containsDoubleLetter(this)
}

// second solution (more functional):
fun String.isNice2(): Boolean {
    val containsBees = setOf("ba", "be", "bu").none { this.contains(it) }

    val hasThreeVowels = count { it in "aeiou" } >= 3

    val containsDoubleLetter = zipWithNext().any { it.first == it.second }

    return listOf(containsBees, hasThreeVowels, containsDoubleLetter).count { it } >= 2
}