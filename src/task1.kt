//Task1 "Вывод списка слов"
fun main(args: Array<String>) {
    val inputString = if (args.isEmpty()) readLine()?.split(" ")?.toList() else args.toList()
    inputString?.forEach(::println)
}