package project.models

/*data class Resource(
    val resourceA: String = "resource A",
    val resourceB: String = "resource B",
    val resourceC: String = "resource C",
)*/

open class ResourceA(){
    val resourceA: String = "resource A"
}
open class ResourceB(): ResourceA() {
    val resourceB: String = "resource B"
}
class ResourceC(): ResourceB() {
    val resourceC: String = "resource C"
}