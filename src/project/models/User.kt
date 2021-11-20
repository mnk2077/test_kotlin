package project.models


data class User(
    var userName: String? = null,
    var userPassword: String? = null,
    var userSalt: String? = null,
    var userRole: List<String>? = null,
    var userResourceWithRoleReed: List<String>? = null,
    var userResourceWithRoleWrite: List<String>? = null,
    var userResourceWithRoleExecute: List<String>? = null,
) {
    init {
        generateRandomSalt()
        setDefaultRole()
        setDefaultResource()
    }

    private fun setDefaultResource(): User {
        if (userResourceWithRoleReed == null) {
            val refResourceA = ResourceA()
            val refResourceB = ResourceB()
            val refResourceC = ResourceC()
            userResourceWithRoleReed = listOf(refResourceA.resourceA, refResourceB.resourceB, refResourceC.resourceC)
        }
        return this
    }

    private fun setDefaultRole(): User {
        if (this.userRole == null) {
            val role = Role()
            userRole = listOf(role.readRole)
        }
        return this
    }

    fun generateRandomSalt(): User {
        if (this.userSalt == null) this.userSalt = generateSalt()
        return this
    }

    private fun generateSalt(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..10)
            .map { allowedChars.random() }
            .joinToString("")
    }
}