//Task5 "Сортировка количества повторений в порядке убывания"
fun main(args: Array<String>) {
        args.groupingBy { it }.eachCount().toSortedMap().toList()
            .sortedByDescending { (_, value) -> value }.toMap().forEach(::println)
}