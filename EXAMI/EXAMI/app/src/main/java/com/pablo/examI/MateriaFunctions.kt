package com.arhakim.examI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.arhakim.examI.Adapter.AdapterProfesor
import com.arhakim.examI.SQLHelper.SQLHelper
import kotlinx.android.synthetic.main.activity_add_materia.edt_Profesor2
import kotlinx.android.synthetic.main.activity_add_materia.edt_id2
import kotlinx.android.synthetic.main.activity_add_materia.edt_name2
import kotlinx.android.synthetic.main.activity_main.edt_name
import kotlinx.android.synthetic.main.activity_main.list_persons

class MateriaFunctions : AppCompatActivity() {

    lateinit var btn_addMateria: Button
    lateinit var btn_updateMateria: Button
    lateinit var btn_deleteMateria: Button
    var listaProfesor:List<Profesor> = ArrayList<Profesor>()
    var listaMaterias:List<Materia> = ArrayList<Materia>()
    lateinit var db: SQLHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_materia)
        initView()

        btn_addMateria.setOnClickListener{
            val materia = Materia(
                Integer.parseInt(edt_id2.text.toString()),
                edt_name2.text.toString()
            )
            db.addMateria(materia, Integer.parseInt(edt_Profesor2.text.toString()))

        }
        //db.addProfesor(profesor)
        //refreshData()


    }

    fun initView() {
        btn_addMateria = findViewById(R.id.btn_addMateria2)
        this.btn_updateMateria = findViewById(R.id.btn_update2)
        this.btn_deleteMateria = findViewById(R.id.btn_delete2)
    }

    private fun refreshData() {
        this.listaMaterias = db.allMaterias
        val adapter = AdapterProfesor(this@MateriaFunctions, listaProfesor, edt_id2, edt_name2, edt_Profesor2)
        list_persons.adapter = adapter
    }
}
