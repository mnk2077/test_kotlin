//Task3 "Вывод только уникальных слов из списка"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList() else args.toList()
    val sortList = inputString?.sorted()
    val uniqueList = sortList?.distinct()?.forEach(::println)
}