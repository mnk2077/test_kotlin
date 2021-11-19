package project.userUtils

import project.models.User

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
            listOf<User>(
                User("Иванов", "5ae85c1cf1bc57cf7e7b98c4cc54e23b","FeDkdDo3XY" ),
                User("Петров", "91f6da7d40095b79525e2610af860d37","pm2bkWhkM8"),
                User("Никитин", "62cc0bf318745468fd15d9984cba6a46", "qoZdatAgsH"),
                User("Линник", "93218283b74ceaa103734608374d793b","ccyunkQxj5")
            )
        )
    }

    fun saveCurrentUser(user: User): Boolean {
        dataUsers.add(user)
        return true
    }

    fun findUsersByName(userName: String?) = dataUsers.find { it.userName == userName }

    fun isUserAlreadyHas(userName: String?) = findUsersByName(userName) != null
}