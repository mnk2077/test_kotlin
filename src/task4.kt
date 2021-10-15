//Task4 "Вывод количества повторений слов в списке"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList() else args.toList()
    val sortList = inputString?.sorted()
    val countList = sortList?.groupingBy { it }?.eachCount()?.toSortedMap()?.forEach(::println)
}