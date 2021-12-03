package project.userUtils

import project.models.User
import java.math.BigInteger
import java.security.MessageDigest

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
                User("Иванов", "5ae85c1cf1bc57cf7e7b98c4cc54e23b","FeDkdDo3XY", listOf("READ"), ds = "04-12-2021 14:32:15", de = "04-12-2021 14:35:45"  ),
                User("Петров", "91f6da7d40095b79525e2610af860d37","pm2bkWhkM8", listOf("READ"),ds = "04-12-2021 14:40:30", de = "04-12-2021 14:41:45" ),
                User("Никитин", "62cc0bf318745468fd15d9984cba6a46", "qoZdatAgsH", listOf("READ"), ds = "04-12-2021 14:41:23", de = "04-12-2021 14:42:56"),
                User("Линник", "93218283b74ceaa103734608374d793b","ccyunkQxj5",ds = "04-12-2021 01:32:00", de = "04-12-2021 01:36:45")
=======
                User("Иванов", "5ae85c1cf1bc57cf7e7b98c4cc54e23b","FeDkdDo3XY"),
                User("Петров", "91f6da7d40095b79525e2610af860d37","pm2bkWhkM8"),
                User("Никитин", "62cc0bf318745468fd15d9984cba6a46", "qoZdatAgsH"),
                User("Линник", "93218283b74ceaa103734608374d793b","ccyunkQxj5")
>>>>>>> Stashed changes
            )
        )
        dataUsers.forEach(::println)
    }

    fun saveCurrentUser(user: User): Boolean {
        user.userPassword = hash(hash(user.userPassword+user.userSalt))
        println(user)
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