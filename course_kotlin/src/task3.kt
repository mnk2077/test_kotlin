//Task3 "Вывод только уникальных слов из списка"
fun main(){
    println("Please enter the line:")
    val inputString = readLine()?.split(" ")?.toList() ?: return
    println("Your line:")
    val sortList = inputString.sorted()
    val uniqueList = sortList.toSet()
    uniqueList.forEach{el -> println(el)}
}