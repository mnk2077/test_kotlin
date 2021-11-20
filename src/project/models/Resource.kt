package project.models

open class ResourceA(){
    val resourceA: String = "resource A"
}
open class ResourceB(): ResourceA() {
    val resourceB: String = "resource B"
}
class ResourceC(): ResourceB() {
    val resourceC: String = "resource C"
}