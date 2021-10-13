//Task4 "Вывод количества повторений слов в списке"
fun main() {
    val inputString = readLine()?.split(" ")?.toList() ?: return
    val sortList = inputString.sorted()
    val countList = sortList.groupingBy { it }.eachCount().toSortedMap()
    countList.forEach(::println)
}