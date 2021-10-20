//Task4 "Вывод количества повторений слов в списке"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList()?.sorted()?.groupingBy { it }?.
    eachCount()?.toSortedMap()?.forEach(::println)
    else args.toList().sorted().groupingBy { it }.eachCount().toSortedMap().forEach(::println)
}