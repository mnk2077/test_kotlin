//Task1 "Вывод списка слов"
fun main() {
    val inputString = readLine()?.split(" ")?.toList() ?: return
    inputString.forEach(::println)
}