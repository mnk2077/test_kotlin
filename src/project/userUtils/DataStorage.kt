package project.userUtils

import project.models.User
import java.math.BigInteger
import java.security.MessageDigest
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DataStorage() {

    private lateinit var dataUsers: MutableList<User>

    init {
        onStart()
    }

    private fun onStart() {
        dataUsers = mutableListOf()
        fillUsersData()
    }

    private fun fillUsersData() {
        dataUsers.addAll(
            listOf(
                User("ivn", "80a306ed12bfb6bd2d5d71eeda1cc4a5","Xr0E55VVdY", listOf("READ"), mutableListOf("resource B"), ds = "04-12-2021 14:32:15", de = "04-12-2021 14:35:45"  ),
                User("ptr", "ee545b7f66eb4ff97ca94cc07415c916","McnQcSqr0n", listOf("READ"),ds = "04-12-2021 14:40:30", de = "04-12-2021 14:41:45" ),
                User("nkt", "36757d1ae8b9c524af68dd6c38ffa6b7", "NGjzQFafVW", listOf("READ"), ds = "04-12-2021 14:41:23", de = "04-12-2021 14:42:56"),
                User("adm", "e42d611d02d997acab77ea66f8793497","TwVnImNfTI",ds = "04-12-2021 01:32:00", de = "04-12-2021 01:36:45")
            )
        )
    }
    private fun getTime(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss") ?: throw Exception("Get time error")
        val formatted = current.format(formatter)
        return formatted
    }

    fun editUserDataStart(user: User) {
        val dataStart = getTime()
        val editUser = dataUsers.find { it.userName == user.userName }
        editUser?.ds = dataStart
        dataUsers.forEach(::println)
    }

    fun saveCurrentUser(user: User): Boolean {
        user.userPassword = hash(hash(user.userPassword+user.userSalt))
        println("Пользователь ${user.userName} зарегестрирован")
        dataUsers.add(user)
        return true

    }
    private fun hash(userPassword: String?): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(userPassword?.toByteArray())).toString(16).padStart(32,'0')
    }
    fun findUsersByName(userName: String?) = dataUsers.find { it.userName == userName }

    fun isUserAlreadyHas(userName: String?) = findUsersByName(userName) != null
}