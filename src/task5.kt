//Task5 "Сортировка количества повторений в порядке убывания"
fun main(args: Array<String>) {
    val inputString =
        readLine()?.split(" ")?.toList()?.sorted()?.groupingBy { it }?.eachCount()?.toSortedMap()?.toList()
            ?.sortedByDescending { (_, value) -> value }?.toMap()
    inputString?.forEach(::println)
}