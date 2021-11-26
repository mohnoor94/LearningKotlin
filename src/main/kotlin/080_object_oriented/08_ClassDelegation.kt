package `080_object_oriented`

data class Customer(val id: Int)

interface Repository {
    fun getById(id: Int): Customer
    fun getAll(): List<Customer>
}

interface Logger {
    fun logAll()
}

// Manual Methods Delegations
class Controller(
    private val repository: Repository,
    private val logger: Logger,
) : Repository, Logger {
    override fun getById(id: Int): Customer = repository.getById(id)
    override fun getAll(): List<Customer> = repository.getAll()
    override fun logAll(): Unit = logger.logAll()

    fun use(controller: Controller) {
        controller.logAll()
    }
}

// Kotlin (Automatic) Methods Delegation
class Controller2(
    private val repository: Repository,
    private val logger: Logger,
) : Repository by repository, Logger by logger {

    fun use(controller: Controller2) {
        controller.logAll()
    }
}
