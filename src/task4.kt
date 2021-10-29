//Task4 "Вывод количества повторений слов в списке"
fun main(args: Array<String>) {
    args.groupingBy { it }.eachCount().toSortedMap().forEach(::println)
}