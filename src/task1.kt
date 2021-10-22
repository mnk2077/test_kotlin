//Task1 "Вывод списка слов"
fun main(args: Array<String>) {
    val inputString = readLine()?.split(" ")?.toList()
    inputString?.forEach(::println)
}