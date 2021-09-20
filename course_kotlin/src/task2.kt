//Task2 "Сортировка списка"
fun main(){
    println("Please enter the line:")
    val inputString = readLine()?.split(" ")?.toList() ?: return
    println("Your line:")
    val sortList = inputString.sorted()
    sortList.forEach{el -> println(el)}
}