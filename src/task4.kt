//Task4 "Вывод количества повторений слов в списке"
fun main(){
    println("Please enter the line:")
    val inputString = readLine()?.split(" ")?.toList() ?: return
    println("Your line:")
    val sortList = inputString.sorted()
    val countList = sortList.groupingBy { it }.eachCount().toSortedMap()
    countList.forEach{el -> println(el)}
}