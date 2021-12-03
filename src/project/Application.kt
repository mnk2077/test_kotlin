package project

import project.userUtils.AuthHelper
import project.userUtils.DataStorage
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

    private fun getStartTime(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss") ?: throw Exception("Get time error")
        val formatted = current.format(formatter)
        println("Текущее время:$formatted")
        return formatted
    }

    private fun onStart() {
        val dataStart = getStartTime()
        dataStorage = DataStorage()
        doAuthUser(dataStart)
    }

    private fun doAuthUser(dataStart: String?) {
        try {
            println("Пожалуйста, введите данные для входа")
            AuthHelper.getUserDataFromConsole().let {
                val isUserAuthorized = AuthHelper.authUser(it, dataStorage)
                val dataEnd = getEndTime()
                dataStorage = DataStorage()
                if (isUserAuthorized) //TODO перекинуть в меню
                    else throw Exception("Error when user auth")
            }
        } catch (e: Exception) {
            println(e.localizedMessage)
            doAuthUser(dataStart)
        }
    }

    private fun getEndTime(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss") ?: throw Exception("Get time error")
        val formatted = current.format(formatter)
        println("Текущее время:$formatted")
        return formatted
    }

}
