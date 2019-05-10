package converter.model


class TextDocumentModel(private val settings: DocumentPrintSettings) {
    val files: MutableList<FileModel> = mutableListOf()

    override fun toString(): String {
        val builder = StringBuilder()
        files.forEach { file ->
            builder.appendln(file)
            builder.appendln(settings.separator)
        }
        return builder.toString()
    }
}