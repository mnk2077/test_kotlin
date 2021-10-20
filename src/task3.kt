//Task3 "Вывод только уникальных слов из списка"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList()?.sorted()?.distinct()?.forEach(::println)
    else args.toList().sorted().distinct().forEach(::println)
}