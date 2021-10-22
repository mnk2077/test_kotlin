//Task2 "Сортировка списка"
fun main(args: Array<String>) {
    val inputString = readLine()?.split(" ")?.toList()?.sorted()
    inputString?.forEach(::println)
}