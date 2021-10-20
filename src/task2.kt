//Task2 "Сортировка списка"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList()?.sorted()?.forEach(::println)
    else args.toList().sorted().forEach(::println)
}