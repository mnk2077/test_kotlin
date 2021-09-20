//Task6 "Вывод строки со стандартного потока"
fun main(){
    println("Please enter the line:")
    val inputString = readLine()?.split(" ")?.toList() ?: return
    println("Your line:")
    val sortList = inputString.sorted()
    val countList = sortList.groupingBy { it }.eachCount().toSortedMap()
    val sortCounted = countList.toList().sortedByDescending { (_,value) -> value }.toMap()
    sortCounted.forEach{el -> println(el)}
}