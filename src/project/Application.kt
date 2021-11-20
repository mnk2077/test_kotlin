package project

import project.userUtils.AuthHelper
import project.userUtils.DataStorage
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
   Application()
}

class Application {

    private lateinit var dataStorage: DataStorage

    init {
        onStart()
    }

    private fun nowTime(){
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted = current.format(formatter)
        println("Текущее время:$formatted")
    }

    private fun onStart() {
        nowTime()
        dataStorage = DataStorage()
        doAuthUser()
    }

    private fun doAuthUser() {
        try {
            println("Пожалуйста, введите данные для входа")
            AuthHelper.getUserDataFromConsole().let {
                val isUserAuthorized = AuthHelper.authUser(it, dataStorage)
                nowTime()
                if (isUserAuthorized) //TODO перекинуть в меню
                    else throw Exception("Error when user auth")
            }
        } catch (e: Exception) {
            println(e.localizedMessage)
            doAuthUser()
        }
    }

}
