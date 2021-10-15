//Task2 "Сортировка списка"
fun main() {
    val inputString = readLine()?.split(" ")?.toList() ?: return
    val sortList = inputString.sorted()
    sortList.forEach(::println)
}