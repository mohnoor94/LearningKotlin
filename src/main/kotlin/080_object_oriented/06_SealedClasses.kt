package `080_object_oriented`

sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    // Error: 'when' expression must be exhaustive, add necessary 'else' branch
    // unless we defined "Expr" with `sealed` modifier.

    // `sealed`: restricts the class hierarchy
    // all subclasses must be located in the same file.
    // no subclasses can extend / implement a sealed class or interface outside this file.
}