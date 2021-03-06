package converter.model

class FileModel(val name: String, val path: String, val text: String) {
    override fun toString(): String {
        val builder = StringBuilder()
        builder.appendln("Name: $name")
        builder.appendln("Path: $path")
        builder.appendln()
        builder.appendln(text)
        return builder.toString()
    }
}