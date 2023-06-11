class Materia {
        var idMateria:String = "";
        var nombreMateria:String ="";
        var creditos:Int? =0;


        constructor(idMateria:String, nombreMateria:String, creditos:Int?) { // Bloque de codigo del constructor

            this.idMateria=idMateria
            this.nombreMateria=nombreMateria
            if (creditos == null) this.creditos=0 else creditos;

        }





}