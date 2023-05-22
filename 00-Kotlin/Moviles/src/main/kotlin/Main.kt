import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    //INMUTABLES (NO SE REASIGNAN "="
    val inmutable = "Pablo";
    //inmutable = "Pablo"

    //Mutables (re asignar)
    var mutable : String = "Pablo";
    mutable = "Pablo"

    //duck typing
    val ejemploVariables = "Pablo Sarzosa"
    ejemploVariables.trim() //Quita los espacios antes y despues de una cadena de caracteres
    val edadEjemplo= "Pablo Sarzosa"




    //Variables primitivas
    val nombreProfesor: String = "Pablo Sarzosa"
    val sueldo: Double = 1.2
    val estadoCivil:Char = 'C'
    val mayorEdad:Boolean= true

    //clases Java
    val fechaNacimiento: Date = Date()


    //Switch
    val estadoCivilWhen = "C"
    when(estadoCivilWhen){
        "C" -> {
            println("Casado")
        }
        "S" -> {
            println("Soltero")
        }
    }
    val coqueteo = if(estadoCivilWhen == "S") "Si" else "No"




    //void -> Unit
    fun imprimirNombre(nombre:String):Unit{
        println("Nombre:  ${nombre}")

    }
    fun calcularSueldo(
        sueldo: Double, //Requerido
        tasa:Double = 12.00, //Opcional (defecto)
        bonoEspecial: Double? =null, //Opcion null - nullable
    ): Double {
        if(bonoEspecial == null){
            return sueldo*(100/tasa)

        }else{
            return sueldo*(100/tasa)+bonoEspecial
        }
    }

    calcularSueldo(10.00,12.00)
    calcularSueldo(10.00, bonoEspecial = 20.00) //named parámeters




    abstract class NumeroJava{

        protected val numeroUno: Int
        private val numeroDos:Int


        constructor(
            uno:Int,
            dos:Int,
        ){
            this.numeroUno=uno
            this.numeroDos=dos
            println("Inicializando")
        }



    }

        abstract class Numeros(//Contructor PRIMARIO)
        //EJemplo:
        // uno: Int, (Parámetro (sin modificador de acceso))
        //Public var uno:Int, //Propiedad publica clase numeros.uno
        //var uno:Int, //Propiedad de la clase ()
        //public var uno:Int
            protected val numeroUno:Int, // Propiedad de la clase protected numeros.numeroUno
            protected val numeroDos:Int //Propiedad de la clase protected numeros.numeroDos
        ){
            init {
                this.numeroUno; this.numeroUno
                numeroUno; numeroDos
                println("Inicializando")
            }
        }

}
