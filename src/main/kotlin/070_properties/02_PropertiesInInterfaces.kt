@file:Suppress("CanBeParameter")

package `070_properties`

interface User {
    val nickname: String
    // properties in interfaces are always "open": they are open to be overridden.
    // they cannot be used in smart-casts.
}

class TwitterUser(private val accountId: String) : User {
    override val nickname: String = accountId // this will be calculated only once.
}

class GmailUser(private val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@') // this will be calculated in each access.
}
