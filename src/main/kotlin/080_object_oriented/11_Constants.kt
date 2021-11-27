package `080_object_oriented`

// const: for primitive types and String --> Generates a runtime constant.

const val answer = 42 // it would be replaced by the value (inline the value).

class MyClass

@JvmField // Instructs the Kotlin compiler not to generate getters/setters for this property and expose it as a field.
val prop = MyClass()

// same as:
// public static final MyClass prop = new MyClass();
// in Java.

object AA {
    @JvmField
    val prob = MyClass() // static field generated
}

class BB {
    @JvmField
    val prob = MyClass() // regular field generated
}

object SuperComputer1 {
    val answer = 42
}
// from Java:
// SuperComputer1.INSTANCE.getAnswer() //answer field itself is private.

object SuperComputer2 {
    @JvmStatic
    val answer = 42
}
// from Java:
// SuperComputer1.getAnswer() // answer field itself is private. but you can access the getter by the class name now (static).

object SuperComputer3 {
    @JvmField
    val answer = 42
}
// from Java:
// SuperComputer1.answer // answer field is exposed now!

object SuperComputer4 {
    const val answer = 42
}
// from Java:
// SuperComputer1.answer // answer field is exposed now!
// Same as SuperComputer3 but we can use `const` for primitive types and Strings only.
// This will be replaced by the compiler to: 42 (the value directly).
// because it's a `const`.
