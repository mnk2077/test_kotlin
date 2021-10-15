//Task3 "Вывод только уникальных слов из списка"
fun main() {
    val inputString = readLine()?.split(" ")?.toList() ?: return
    val sortList = inputString.sorted()
    val uniqueList = sortList.distinct()
    uniqueList.forEach(::println)
}