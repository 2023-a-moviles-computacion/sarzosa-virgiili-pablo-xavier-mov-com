package com.example.movilescomp2023a

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.example.movilescomp2023a.R.*

class MainActivity : AppCompatActivity() {

    val callbackContenidoIntentExplicito = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            if (result.data != null) {
                // Logica Negocio
                val data = result.data
                "${data?.getStringExtra(" nombreModificado ")}"
            }
        }
    }



    val callbackIntentPickUri =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode === RESULT_OK) {
                if (result.data != null) {
                    if (result.data!!.data != null) {
                        val uri: Uri = result.data!!.data!!
                        val cursor = contentResolver.query(uri, null, null, null, null, null)
                        cursor?.moveToFirst()
                        val indiceTelefono = cursor?.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )
                        val telefono = cursor?.getString(indiceTelefono!!)
                        cursor?.close()
                        "Telefono S{telefono}"
                    }
                }
            }
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //Base SQL lite
        EBaseDeDatos.tablaEntrenador = ESqliteHelperEntrenador(this)




        val botonCicloVida = findViewById<Button>(R.id.btn_cicloVida)
        botonCicloVida
            .setOnClickListener {
                irActividad(AACicloVida::class.java)
            }

        val botonListView = findViewById<Button>(R.id.btn_ir_list_view)

        botonListView.setOnClickListener {
            irActividad(BListView::class.java)
        }
        val botonIntentImplicito = findViewById<Button>(R.id.btn_ir_list_view)
        botonIntentImplicito
            .setOnClickListener {
                val intentConRespuesta = Intent(
                    Intent.ACTION_PICK,
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                )
                callbackIntentPickUri.launch(intentConRespuesta)
            }
        val botonIntentExplicito = findViewById<Button>(R.id.btn_ir_list_view)
        botonIntentExplicito
            .setOnClickListener {
                abrirActividadConParametros(CIntentExplicitoParametros::class.java)
            }


        val botonSqlite = findViewById<Button>(R.id.btn_sqlite)
        botonSqlite
            .setOnClickListener {
                irActividad(ECrudEntrenador::class.java)
            }
        val botonRView = findViewById<Button>(R.id.btn_revcycler_view)
        botonRView
            .setOnClickListener {
                irActividad(FRecyclerView::class.java)
            }

    }










fun abrirActividadConParametros (
    clase: Class<*>
){

    val intentExplicito = Intent (this, clase)
// Enviar parametros (solamente variables primitivas)
    intentExplicito.putExtra("nombre", "Adrian")
    intentExplicito.putExtra("apellido", "Eguez")
    intentExplicito.putExtra("edad", 34)
    callbackContenidoIntentExplicito.launch(intentExplicito)

}






    @SuppressLint("SuspiciousIndentation")
    fun irActividad(clase: Class<*>) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}