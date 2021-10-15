//Task6 "Вывод строки со стандартного потока"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList() else args.toList()
    val sortList = inputString?.sorted()
    val countList = sortList?.groupingBy { it }?.eachCount()?.toSortedMap()
    val sortCounted = countList?.toList()?.sortedByDescending { (_, value) -> value }?.toMap()
    sortCounted?.forEach(::println)
}