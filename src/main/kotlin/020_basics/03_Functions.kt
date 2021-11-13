package `020_basics`

// You can define functions everywhere

// Top-Level functions:
// To call this from Java, you need to call it as a static function if a call, which name
// is corresponds to the file name.
// or, read about @JvmName annotation, example: @file:JvmName("Util"), then you can use "Util" as the
// class name instead of the file name
fun topLevel() = 1


class `03_Functions` {

    // Member functions
    fun member() = 2


    fun otherMember() {

        // Local functions
        fun local() = 3
    }
}