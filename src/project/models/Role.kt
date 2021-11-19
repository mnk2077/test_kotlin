package project.models

data class Role(
    var readRole: String = "READ",
    var writeRole: String = "WRITE",
    var executeRole: String = "EXECUTE"
)
