package project.userUtils

import project.models.User
import java.math.BigInteger
import java.security.MessageDigest

object AuthHelper {
    fun getUserDataFromConsole(): User {
        return User().apply {
            userName = getFieldFromConsoleLine("логин")
            userPassword = getFieldFromConsoleLine("пароль")
        }
    }

    private fun getFieldFromConsoleLine(fieldName: String): String {
        print("Введите $fieldName: ")
        return readLine() ?: throw Exception("Data is null")
    }

    fun authUser(user: User, context: DataStorage): Boolean {
        return if (context.isUserAlreadyHas(user.userName))
            signIn(user, context)
        else signUp(user, context)
    }

    private fun signUp(user: User,context: DataStorage): Boolean {
        //TODO Авторизовать пользователя, если всё ок - вывести сообщение "Успешно" и вернуть true, если нет false
        val foundedUser = context.findUsersByName(user.userName)
        var success = false
        if (foundedUser == null){
            success = context.saveCurrentUser(user)
        }
        return success
    }

    private fun signIn(user: User, context: DataStorage): Boolean {
        //TODO Авторизовать пользователя, если всё ок - вывести сообщение "Успешно" и вернуть true, если нет false
        val foundedUser = context.findUsersByName(user.userName) ?: throw Exception("User not founded")
        val hashPassword = hash(hash(user.userPassword)+foundedUser.userSalt)
        println(hashPassword)
        println(foundedUser.userSalt)
        return if (foundedUser.userPassword == hashPassword) {
            println("User is auth")
            true
        } else {
            println("Error in Auth")
            false
        }
    }

    private fun hash(userPassword: String?): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(userPassword?.toByteArray())).toString(16).padStart(32,'0')
    }
}