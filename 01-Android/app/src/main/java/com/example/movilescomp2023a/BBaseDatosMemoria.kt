import com.example.movilescomp2023a.BEntrenador

class BBaseDatosMemoria {
    companion object{
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init{
            arregloBEntrenador
                .add(
                    BEntrenador(1, "Elisa", "e@e.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2, "Andrea", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3, "Ron", "r@r.com")
                )
        }
    }
}