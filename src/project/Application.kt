package project

import project.userUtils.AuthHelper
import project.userUtils.DataStorage

fun main(args: Array<String>) {
    Application()
}

class Application {

    private lateinit var dataStorage: DataStorage

    init {
        onStart()
    }

    private fun onStart() {
        dataStorage = DataStorage()
        doAuthUser()
    }

    private fun doAuthUser() {
        try {
            println("Пожалуйста, введите данные для входа")
            AuthHelper.getUserDataFromConsole().let {
                val isUserAuthorized = AuthHelper.authUser(it, dataStorage)
                dataStorage.editUserDataStart(it)
                if (isUserAuthorized) //TODO перекинуть в меню
                else throw Exception("Error when user auth")
            }
        } catch (e: Exception) {
            println(e.localizedMessage)
            doAuthUser()
        }
    }

}