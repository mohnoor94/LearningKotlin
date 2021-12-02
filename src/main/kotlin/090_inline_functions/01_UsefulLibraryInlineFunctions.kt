@file:Suppress("KotlinConstantConditions", "RedundantNullableReturnType")

package `090_inline_functions`

// Functions look like original language constructs with no added overhead

// Useful inline library functions

fun main() {
    println("***** `run` *****")
    // runs the block of code (lambda) and returns the last expression as the result

    val foo = run {
        println("hello")
        5
    }

    println(foo)
    println(foo)
    println("*".repeat(50))

    println("***** `let` *****")
    // allows to check the argument for being non-null, not only the receiver

    val name: String? = "Noor"

    if (name != null) {
        println("Name is not null...")
    }

    // We can work with this nullable types with let as well.

    name?.let { println(it.length) } // only do the lambda if the name is not-null
    val val1: Unit? = name?.let { println(name.javaClass) } // work with nullables (with safe access ?)
    val val2: Unit = name.let { println(name?.javaClass ?: "name is null") } // did not check for nullability

    println()

    // another example
    open class User
    class FacebookUser(val accountId: String): User()
    class Session(val user: User)

    fun analyzeUserSession1(session: Session) {
        val user = session.user // we need this variable before doing the safe casting
        if (user is FacebookUser) {
            println(user.accountId) // it --> FacebookUser
        }
    }

    fun analyzeUserSession2(session: Session) {
        // no need to extract an additional variable
        (session.user as? FacebookUser)?.let {
            println(it.accountId) // it --> FacebookUser
        }
    }

    val session = Session(FacebookUser("123"))
    analyzeUserSession1(session)
    analyzeUserSession2(session)

    println("*".repeat(50))

    println("***** `takeIf` *****")
    // returns the receiver object if it satisfies the given predicate, otherwise it returns null

    val number = 42
    val n1: Int? = number.takeIf { it > 10 }
    val n2: Int? = number.takeIf { it < 10 }

    println("n1 --> $n1") // 42
    println("n2 --> $n2") // null

    // `takeIf` In chained calls

    class Issue(val isOpen: Boolean)

    val issues1 = listOf(Issue(true), Issue(false), Issue(false))
    val issues2 = listOf(Issue(false), Issue(false), Issue(false))

    fun checkForIssues(issues: List<Issue>) {
        issues.filter { it.isOpen }
            .takeIf { it.isNotEmpty() }
            ?.let { println("There are some open issues") } // we reach her only if the previous call is not null
    }

    checkForIssues(issues1) // There are some open issues
    checkForIssues(issues2) // <<No output>>

    println("***** `takeUnless` *****")
    // returns the receiver object if it does not satisfy the given predicate, otherwise it returns null

    val n3: Int? = number.takeUnless { it > 10 }
    val n4: Int? = number.takeUnless { it < 10 }


    println("n3 --> $n3") // null
    println("n4 --> $n4") // 42

    println("***** `repeat` *****")
    // repeats an action a given number of times

    repeat(10) {
        println("Hello $it")
    }
}
