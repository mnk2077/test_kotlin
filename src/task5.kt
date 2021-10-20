//Task5 "Сортировка количества повторений в порядке убывания"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList()?.sorted()?.groupingBy { it }?.
    eachCount()?.toSortedMap()?.toList()?.sortedByDescending { (_, value) -> value }?.toMap()?.forEach(::println)
    else args.toList().sorted().groupingBy { it }.eachCount().toSortedMap().toList().
    sortedByDescending { (_, value) -> value }.toMap().forEach(::println)
}