//Task1 "Вывод списка слов"
fun main(){
    println("Please enter the line:")
    val inputString = readLine()?.split(" ")?.toList() ?: return
    println("Your line:")
    inputString.forEach{el -> println(el)}
}