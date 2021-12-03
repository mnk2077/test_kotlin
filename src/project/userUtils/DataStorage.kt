package project.userUtils

import project.models.User
import java.math.BigInteger
import java.security.MessageDigest

class DataStorage(ds: String?, de: String?) {

    private lateinit var dataUsers: MutableList<User>

    init {
        onStart(ds, de)
    }

    private fun onStart(ds: String?, de: String?) {
        dataUsers = mutableListOf()
        fillUsersData(ds, de)
    }

    private fun fillUsersData(ds: String?, de: String?) {
        dataUsers.addAll(
            listOf<User>(
                User("Иванов", "5ae85c1cf1bc57cf7e7b98c4cc54e23b","FeDkdDo3XY", ds = ds, de = de ),
                User("Петров", "91f6da7d40095b79525e2610af860d37","pm2bkWhkM8"),
                User("Никитин", "62cc0bf318745468fd15d9984cba6a46", "qoZdatAgsH"),
                User("Линник", "93218283b74ceaa103734608374d793b","ccyunkQxj5")
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