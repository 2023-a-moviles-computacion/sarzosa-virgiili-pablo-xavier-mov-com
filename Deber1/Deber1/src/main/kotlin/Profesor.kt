class Profesor {

    var cedula:Int? = 0
    var nombre1:String = "";
    var nombre2:String? ="";
    var apellido1:String ="";
    var apellido2:String ="";
    var titulo:String = ""

    constructor(cedula: Int?, nombre1:String, nombre2:String?, apellido1:String, apellido2:String, titulo:String) { // Bloque de codigo del constructor
        this.cedula =  cedula
        this.nombre1=nombre1
        if (nombre2 == null) this.nombre2="" else nombre2;
        this.apellido1=apellido1
        this.apellido2=apellido2
        this.titulo=titulo
    }


    public fun myFunction() {
        // Function implementation goes here
        println("Hello from myFunction!")
    }


}