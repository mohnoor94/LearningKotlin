package `080_object_oriented`

// Inner Classes:
// Stores a reference to the outer class (not static in Java).

// Nested Classes:
// Does not store a reference to the outer class (static in Java).
// default case

class A {
    class B // nested / no ref to A
    inner class C { // inner / have a ref to A
        // this@A to access the outer class A.
    }
}