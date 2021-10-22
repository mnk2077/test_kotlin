//Task3 "Вывод только уникальных слов из списка"
fun main(args: Array<String>) {
    val inputString = readLine()?.split(" ")?.toList()?.sorted()?.distinct()
    inputString?.forEach(::println)
}