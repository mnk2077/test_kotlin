//Task5 "Сортировка количества повторений в порядке убывания"
fun main() {
    val inputString = readLine()?.split(" ")?.toList() ?: return
    val sortList = inputString.sorted()
    val countList = sortList.groupingBy { it }.eachCount().toSortedMap()
    val sortCounted = countList.toList().sortedByDescending { (_, value) -> value }.toMap()
    sortCounted.forEach(::println)
}