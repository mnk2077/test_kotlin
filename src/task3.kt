//Task3 "Вывод только уникальных слов из списка"
fun main(args: Array<String>) {
    args.distinct().forEach(::println)
}