package com.arhakim.examI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.arhakim.examI.SQLHelper.SQLHelper
import kotlinx.android.synthetic.main.activity_add_materia.edt_id2
import kotlinx.android.synthetic.main.activity_add_materia.edt_name2
import kotlinx.android.synthetic.main.activity_main.btn_addProfesor

class MateriaFunctions : AppCompatActivity() {

    lateinit var btn_addMateria: Button
    lateinit var btn_updateMateria: Button
    lateinit var btn_deleteMateria: Button

    lateinit var db: SQLHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_materia)
        initView()


        //db.addProfesor(profesor)
        //refreshData()


    }

    fun initView() {
        btn_addMateria = findViewById(R.id.btn_addMateria2)
        this.btn_updateMateria = findViewById(R.id.btn_update2)
        this.btn_deleteMateria = findViewById(R.id.btn_delete2)
    }
}
