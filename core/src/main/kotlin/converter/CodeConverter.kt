package converter

import converter.model.TextDocumentModel
import java.io.File

class CodeConverter(private val extensions: List<String>) {

    fun convertFrom(basePath: File, excludedFiles: List<File>):String {
        val document = TextDocumentModel()

        val treeWalk = basePath.walkTopDown()
            .filter { file -> file.containsExtension(extensions) && !excludedFiles.contains(file) }

        treeWalk.forEach { file ->
            document.files.add(file.toFileModel())
        }
        return document.toString()
    }
}