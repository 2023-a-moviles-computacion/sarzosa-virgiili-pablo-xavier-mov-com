package com.arhakim.examI.SQLHelper


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.arhakim.examI.Materia
import com.arhakim.examI.Profesor

class SQLHelper(context:Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "MOVILES.db1"

        //Tabla Profesor
        private val TABLE_NAME = "Profesor"
        private val COL_ID_PROFESOR = "Id"
        private val COL_NAME_PROFESOR = "Name"
        private val COL_EMAIL_PROFESOR = "Email"

        //Tabla Materia
        private val TABLE_NAME_MATERIA = "Materia"
        private val COL_ID_MATERIA = "IdMateria"
        private val COL_NAME_MATERIA = "NameMateria"
        private val COL_ID_PROFESOR_FOREIGN= "idProfesor"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY_PROFESOR = ("CREATE TABLE $TABLE_NAME($COL_ID_PROFESOR INTEGER PRIMARY KEY, " +
                "$COL_NAME_PROFESOR TEXT, " +
                "$COL_EMAIL_PROFESOR TEXT)")

        val CREATE_TABLE_QUERY_MATERIA= ("CREATE TABLE $TABLE_NAME_MATERIA($COL_ID_MATERIA INTEGER PRIMARY KEY, " +
                "$COL_NAME_MATERIA TEXT, " +
                "$COL_ID_PROFESOR_FOREIGN INTEGER,"+
                "FOREIGN KEY ($COL_ID_PROFESOR_FOREIGN) REFERENCES Profesor(Id))")



        db!!.execSQL(CREATE_TABLE_QUERY_PROFESOR)
        db!!.execSQL(CREATE_TABLE_QUERY_MATERIA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    //Get List Profesors
    val allProfesors:List<Profesor>
        get(){
            val lstProfesors = ArrayList<Profesor>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if(cursor.moveToFirst()) {
                do{
                    val profesor = Profesor()
                    profesor.id = cursor.getInt(cursor.getColumnIndex(COL_ID_PROFESOR))
                    profesor.name = cursor.getString(cursor.getColumnIndex(COL_NAME_PROFESOR))
                    profesor.email = cursor.getString(cursor.getColumnIndex(COL_EMAIL_PROFESOR))

                    lstProfesors.add(profesor)
                } while (cursor.moveToNext())
            }
            db.close()
            return lstProfesors
        }



    val allMaterias:List<Materia>
        get(){
            val lstProfesors = ArrayList<Materia>()
            val selectQuery = "SELECT * FROM $TABLE_NAME_MATERIA"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if(cursor.moveToFirst()) {
                do{
                    val materia = Materia()
                    materia.id = cursor.getInt(cursor.getColumnIndex(COL_ID_MATERIA))
                    materia.name = cursor.getString(cursor.getColumnIndex(COL_NAME_MATERIA))


                    lstProfesors.add(materia)
                } while (cursor.moveToNext())
            }
            db.close()
            return lstProfesors
        }


    fun addMateria(materia: Materia, IdProfesor:Int) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID_MATERIA, materia.id)
        values.put(COL_NAME_MATERIA, materia.name)
        values.put(COL_NAME_MATERIA, materia.name)
        values.put(COL_ID_PROFESOR_FOREIGN, IdProfesor)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun addProfesor(profesor: Profesor) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID_PROFESOR, profesor.id)
        values.put(COL_NAME_PROFESOR, profesor.name)
        values.put(COL_EMAIL_PROFESOR, profesor.email)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateProfesor(profesor: Profesor): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID_PROFESOR, profesor.id)
        values.put(COL_NAME_PROFESOR, profesor.name)
        values.put(COL_EMAIL_PROFESOR, profesor.email)

        return db.update(TABLE_NAME, values, "$COL_ID_PROFESOR=?", arrayOf(profesor.id.toString()))
    }

    fun deleteProfesor(profesor: Profesor) {
        val db = this.writableDatabase

        db.delete(TABLE_NAME, "$COL_ID_PROFESOR=?", arrayOf(profesor.id.toString()))
        db.close()
    }
}