import converter.CodeConverter
import converter.model.DocumentPrintSettings
import java.io.File

fun main(args: Array<String>) {
    if (args.size <= 2)
        throw IllegalArgumentException("Unexpected arguments count ${args.size}")


    val basePath = File(args[0])
    if (!(basePath.exists() && basePath.isDirectory))
        throw IllegalArgumentException("Incorrect directory path")


    val outputFile = File(args[1])
    if (!outputFile.exists())
        outputFile.createNewFile()
    if (!outputFile.isFile)
        throw IllegalArgumentException("Incorrect output path")


    val extensions = args[2].trim().split(" ")

    val separator = if (args.size > 3) args[3] else "\n\n"
    val documentSettings = DocumentPrintSettings(separator)

    val converter = CodeConverter(extensions, documentSettings)
    outputFile.writeText(converter.convertFrom(basePath, listOf()))
}