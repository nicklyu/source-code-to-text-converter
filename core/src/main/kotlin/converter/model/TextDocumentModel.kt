package converter.model


class TextDocumentModel {
    val files: MutableList<FileModel> = mutableListOf()

    override fun toString(): String {
        val builder = StringBuilder()
        files.forEach{file->
            builder.appendln(file)
            builder.appendln()
            builder.appendln()
        }
        return builder.toString()
    }
}