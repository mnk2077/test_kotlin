//Task6 "Вывод строки со стандартного потока"
fun main(args: Array<String>) {
    val inputList: List<String>? = if (args.isEmpty()) readLine()?.split(" ")?.toList()
    else args.toList()
    printList(inputList)
}

fun printList(args: List<String>?) {
    args?.sorted()?.groupingBy { it }?.eachCount()?.toSortedMap()?.toList()
        ?.sortedByDescending { (_, value) -> value }?.toMap()?.forEach(::println)
}