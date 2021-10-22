//Task4 "Вывод количества повторений слов в списке"
fun main(args: Array<String>) {
    val inputString =
        readLine()?.split(" ")?.toList()?.sorted()?.groupingBy { it }?.eachCount()?.toSortedMap()
    inputString?.forEach(::println)
}