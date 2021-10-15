//Task5 "Сортировка количества повторений в порядке убывания"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList() else args.toList()
    val sortList = inputString?.sorted()
    val countList = sortList?.groupingBy { it }?.eachCount()?.toSortedMap()
    val sortCounted = countList?.toList()?.sortedByDescending { (_, value) -> value }?.toMap()?.forEach(::println)
}