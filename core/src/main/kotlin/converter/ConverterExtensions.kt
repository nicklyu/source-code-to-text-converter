package converter

import converter.model.FileModel
import java.io.File

fun File.containsExtension(extensions: List<String>) = extensions.any {extension-> this.name.endsWith(extension) }

fun File.toFileModel(baseDirectory: String) = FileModel(this.name, this.path.removePrefix(baseDirectory), this.readText())