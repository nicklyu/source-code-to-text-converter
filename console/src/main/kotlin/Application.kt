import converter.CodeConverter
import java.io.File

fun main(args:Array<String>){
    assert(args.size == 2)
    val basePath = File(args[0])
    assert(basePath.exists() && basePath.isDirectory)
    val extensions = args[1].trim().split(" ")
    val converter = CodeConverter(extensions)
    println(converter.convertFrom(basePath, listOf()))
}