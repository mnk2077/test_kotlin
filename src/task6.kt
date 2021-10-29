//Task6 "Вывод строки со стандартного потока"
fun main(args: Array<String>){
    if (args.isEmpty()) readLine()?.split(" ")?.toList()?.sorted()?.groupingBy { it }?.
    eachCount()?.toSortedMap()?.toList()?.sortedByDescending { (_, value) -> value }?.toMap()?.forEach(::println)
    else args.toList().sorted().groupingBy { it }.eachCount().toSortedMap().toList().
    sortedByDescending { (_, value) -> value }.toMap().forEach(::println)
}