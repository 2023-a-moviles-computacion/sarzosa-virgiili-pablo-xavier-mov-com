package com.arhakim.examI



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arhakim.examI.Adapter.AdapterProfesor
import com.arhakim.examI.SQLHelper.SQLHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     lateinit var db: SQLHelper


     var listaProfesores:List<Profesor> = ArrayList<Profesor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = SQLHelper(this)

        refreshData()

        btn_addProfesor.setOnClickListener {
            val profesor = Profesor(
                    Integer.parseInt(edt_id.text.toString()),
                    edt_name.text.toString(),
                    edt_email.text.toString()
            )
            db.addProfesor(profesor)
            refreshData()
        }

        btn_update.setOnClickListener {
            val profesor = Profesor(
                    Integer.parseInt(edt_id.text.toString()),
                    edt_name.text.toString(),
                    edt_email.text.toString()
            )
            db.updateProfesor(profesor)
            refreshData()
        }

        btn_delete.setOnClickListener {
            val profesor = Profesor(
                    Integer.parseInt(edt_id.text.toString()),
                    edt_name.text.toString(),
                    edt_email.text.toString()
            )

            db.deleteProfesor(profesor)
            refreshData()
        }

        btn_addMateria.setOnClickListener{
            val intent = Intent(this, MateriaFunctions::class.java)
            startActivity(intent)
        }
    }

    private fun refreshData() {
        listaProfesores = db.allProfesors
        val adapter = AdapterProfesor(this@MainActivity, listaProfesores, edt_id, edt_name, edt_email)
        list_persons.adapter = adapter
    }
}