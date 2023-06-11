import java.io.File
import java.util.ArrayList

class InputOutput {

    constructor(){

    }


    fun saveTextFile(fileName: String, content: String) {
        val file = File(fileName)
        file.writeText(content)
    }



    fun readTextFile(fileName: String): String {
        val file = File(fileName)
        return file.readText()
    }

    fun listTextFile(directoryPath:String): ArrayList<String> {
        val listOfFiles: ArrayList<String> = arrayListOf<String>()
        val directory = File(directoryPath)
        val files = directory.listFiles()

        if (files != null) {
            for (file in files) {
                if (file.isFile) {
                    listOfFiles.add(file.name)
                }
            }
        }
        return listOfFiles
    }




}