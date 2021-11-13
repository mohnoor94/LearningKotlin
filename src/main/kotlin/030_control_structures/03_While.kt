package `030_control_structures`


// while and do-while are the same as in Java


fun main() {

    // while
    var i = 1

    while (i < 5) {
        println("i = $i")
        i++
    }


    println("=========")

    // do-while

    var j = 1

    do {
        println("j = $j")
        j++
    } while (j < 5)
}
