package project.models


data class User(
    var userName: String? = null,
    var userPassword: String? = null,
    var userSalt: String? = null,
    var userRole: List<String>? = null,
    var userResourceWithRoleReed: MutableList<String>? = null,
    var userResourceWithRoleWrite: List<String>? = null,
    var userResourceWithRoleExecute: List<String>? = null,
    var ds: String? = null,
    var de: String? = null
) {
    init {
        generateRandomSalt()
        setStartTime()
        setEndTime()
        setDefaultRole()
        setDefaultResource()
    }

    private fun setEndTime() {
        return
    }

    private fun setStartTime() {
        return
    }

    private fun setDefaultResource(): User {
        val refResourceA = ResourceA()
        val refResourceB = ResourceB()
        val refResourceC = ResourceC()
        if (userResourceWithRoleReed == null) {
            userResourceWithRoleReed = mutableListOf(refResourceA.resourceA, refResourceB.resourceB, refResourceC.resourceC)
        }else if (userResourceWithRoleReed?.get(0) == refResourceA.resourceA) {
            userResourceWithRoleReed?.add(refResourceB.resourceB)
            userResourceWithRoleReed?.add(refResourceC.resourceC)
        }else if (userResourceWithRoleReed?.get(0) == refResourceB.resourceB)
            userResourceWithRoleReed?.add(refResourceC.resourceC)

        return this
    }

    private fun setDefaultRole(): User {
        if (this.userRole == null) {
            val role = Role()
            userRole = listOf(role.readRole)
        }
        return this
    }

    private fun generateRandomSalt(): User {
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
