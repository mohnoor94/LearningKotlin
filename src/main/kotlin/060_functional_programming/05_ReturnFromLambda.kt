package `060_functional_programming`

fun main() {
    // `return` is always return from the function marked with `fun`!!

    fun duplicateNonZero1(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) return listOf()
            listOf(it, it)
        }
    }

    println(duplicateNonZero1(listOf(1, 0, 7))) // []... we returned in line 8 ... WTF!
    // It's done so that these functions behave like language constructs,
    // for example, a return in a "forEach" function is behaving just like a return in a normal for loop.
    // interesting but meh...


    // return from Lambda:
    // 1. Use functionType return (@flatMap) (meh)
    fun duplicateNonZero2(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) return@flatMap listOf()
            listOf(it, it)
        }
    }

    println(duplicateNonZero2(listOf(1, 0, 7))) // [1, 1, 7, 7]

    // 2. Use a custom label (@l1) (meh)
    fun duplicateNonZero3(list: List<Int>): List<Int> {
        return list.flatMap l1@{
            if (it == 0) return@l1 listOf()
            listOf(it, it)
        }
    }

    println(duplicateNonZero3(listOf(1, 0, 7))) // [1, 1, 7, 7]

    // 3. Convert the lambda to a normal function and reference it to a lambda (meh)
    fun duplicateNonZero4(list: List<Int>): List<Int> {
        fun duplicateNonZeroElement(e: Int): List<Int> {
            if (e == 0) return listOf()
            return listOf(e, e)
        }

        return list.flatMap(::duplicateNonZeroElement)
    }

    println(duplicateNonZero4(listOf(1, 0, 7))) // [1, 1, 7, 7]

    // 4. Convert the lambda to an anonymous function (meh)
    fun duplicateNonZero5(list: List<Int>): List<Int> {
        return list.flatMap(fun(e): List<Int> {
            if (e == 0) return listOf()
            return listOf(e, e)
        })
    }

    println(duplicateNonZero5(listOf(1, 0, 7))) // [1, 1, 7, 7]

    // 5. Omit the return from inside the lambda. It will work as expected (... not so meh)
    fun duplicateNonZero6(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) listOf()
            else listOf(it, it) // we needed the else here
        }
    }

    println(duplicateNonZero6(listOf(1, 0, 7))) // [1, 1, 7, 7]

}
