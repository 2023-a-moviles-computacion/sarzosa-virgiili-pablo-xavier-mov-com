import java.util.ArrayList

fun main(args: Array<String>) {

    val pathProfesores= "/Users/pavox20/Downloads/eguez-sarzosa-vicente-adrian-mov-com-main/00-Kotlin/Moviles/Profesores/"
    val pathMaterias="/Users/pavox20/Downloads/eguez-sarzosa-vicente-adrian-mov-com-main/00-Kotlin/Moviles/Materias/"
    var flag: Boolean = true
    val inputOutput: InputOutput = InputOutput()

    while (flag) {
        println(
            "Bienvenido, ¿Qué deseas hacer configurar?\n" + "A: Profesor\n" + "B: Materia\n" + "C: Salir\n"
        )

        print("Ingresa la opción: ")
        val option = readLine()?.uppercase()
        when (option) {

            "A" -> {


                var flagProfesores: Boolean = true;


                while (flagProfesores) {
                    println(
                        "¿Qué deseas hacer?\n" + "A: Agregar Profesor\n" + "B: Listar Profesores\n" + "C: Buscar un Profesor\n" + "D: Eliminar un Profesor\n" + "E: Regresar\n"+"F: Salir")
                    print("Ingresa la opción: ")
                    var optionProfesores = readLine()?.uppercase()

                    when (optionProfesores) {
                        "A" -> {

                            print("\nIngresa la cédula: ")
                            var value = readLine()
                            val cedula: Int? = value?.toInt()
                            print("\nIngresa el primer nombre: ")
                            value = readLine()
                            val nombre1: String = value.toString()
                            print("\nIngresa el segundo nombre (Si no tiene dejar vacío): ")
                            value = readLine()
                            val nombre2: String = value.toString()
                            print("\nIngresa el primer apellido: ")
                            value = readLine()
                            val apellido1: String = value.toString()
                            print("\nIngresa el segundo apellido: ")
                            value = readLine()
                            val apellido2: String = value.toString()
                            print("\nIngresa el titulo del Profesor: ")
                            value = readLine()
                            val titulo: String = value.toString()
                            val profesor: Profesor = Profesor(
                                cedula = cedula,
                                nombre1 = nombre1,
                                nombre2 = nombre2,
                                apellido1 = apellido1,
                                apellido2 = apellido2,
                                titulo = titulo
                            )
                            val content:String= "$cedula-$nombre1 $nombre2 $apellido1 $apellido2-$titulo"

                            inputOutput.saveTextFile(fileName = pathProfesores+"$cedula.txt", content = content)
                            println("\nSe ha guardado con éxito!\n")
                        }
                        "B" -> {

                            val listOfFiles: ArrayList<String> = inputOutput.listTextFile(pathProfesores)
                            for (name in listOfFiles) {
                                val num:Int = name.indexOf(name)+1
                                println("$num: $name")

                            }

                        }
                        "C" -> {



                        }

                        "E" -> {
                            flagProfesores = false
                        }

                        "F" -> {
                            flagProfesores = false
                            flag = false
                        }

                        else -> {
                            // Code to execute for invalid options
                            println("Invalid option selected.")
                        }

                    }


                }


            }

            "B" -> {


                var flagMaterias: Boolean = true;


                while (flagMaterias) {
                    println(
                        "¿Qué deseas hacer?\n" + "A: Agregar una Materia\n" + "B: Buscar Materia\n" + "C: Eliminar una Materia\n" + "D: Regresar\n" + "E: Salir\n"
                    )
                    print("Ingresa la opción: ")
                    var optionMateria = readLine()?.uppercase()

                    when (optionMateria) {
                        "A" -> {

                            print("\nIngresa el ID de la Materia: ")
                            var value = readLine()
                            val idMateria: String = value.toString()
                            print("\nIngresa el nombre de la Materia: ")
                            value = readLine()
                            val nombreMateria: String = value.toString()
                            print("\nIngresa los créditos de la Materia: ")
                            value = readLine()
                            val creditos: Int? = value?.toInt()


                            val materia: Materia =
                                Materia(idMateria = idMateria, nombreMateria = nombreMateria, creditos = creditos)

                            val content:String= "$idMateria-$nombreMateria-$creditos"

                            inputOutput.saveTextFile(fileName = pathMaterias+"$idMateria-$nombreMateria.txt", content = content)


                            println("\nSe ha guardado con éxito!\n")

                        }

                        "D" -> {
                            flagMaterias = false
                        }

                        "E" -> {
                            flagMaterias = false
                            flag = false
                        }

                        else -> {
                            // Code to execute for invalid options
                            println("Invalid option selected.")
                        }

                    }


                }


            }

            "C" -> {

                flag = false;
            }

            else -> {
                // Code to execute for invalid options
                println("Invalid option selected.")
            }


        }

    }


}






