//Task2 "Сортировка списка"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList() else args.toList()
    val sortList = inputString?.sorted()?.forEach(::println)
}