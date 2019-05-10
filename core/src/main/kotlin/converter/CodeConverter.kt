package converter

import converter.model.DocumentPrintSettings
import converter.model.TextDocumentModel
import java.io.File

class CodeConverter(private val extensions: List<String>, private val documentSettings: DocumentPrintSettings) {

    fun convertFrom(basePath: File, excludedFiles: List<File>):String {
        val document = TextDocumentModel(documentSettings)

        val treeWalk = basePath.walkTopDown()
            .filter { file -> file.containsExtension(extensions) && !excludedFiles.contains(file) }

        treeWalk.forEach { file ->
            document.files.add(file.toFileModel(basePath.path))
        }

        return document.toString()
    }
}