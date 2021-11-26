package `080_object_oriented`

// Modifiers:
// public (visible everywhere)
// protected (visible in the class and its subclasses, and not to the package)
// private (visible in the class only for class members, and visible in the file for top-level declarations)
// internal (visible to the module)
// -- no package-private in Kotlin.

// final (Cannot be overridden)
// open (can be overridden)
// abstract (must be overridden, cannot have implementation)

// Default Modifiers:
// public & final

// Module - a set of Kotlin files compiled together:
// - An IntelliJ IDEA module
// - A Maven project
// - A Gradle source set

// override is a modifier and not an annotation in Kotlin - it means to override a member form the superclass/interface.
// it's mandatory to be written when we override a member (not optional like in Java).

// ...

// A file could have multiple classes (especially if they are simple data classes) and many top-level functions.

// A package name could be different from the file structure.
// Kotlin style guide: you may remove the company name and use the rest of the file structure for your package names,
// to make things clear and easy.
