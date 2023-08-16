package com.arhakim.examI.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.arhakim.examI.Materia
import com.arhakim.examI.Profesor
import com.arhakim.examI.R
import kotlinx.android.synthetic.main.row_layout.view.*

class AdapterProfesor(internal var activity: Activity,
                      internal var lstProfesors: List<Profesor>,
                      internal var edt_id: EditText,
                      internal var edt_name: EditText,
                      internal var edt_email: EditText):BaseAdapter() {

    internal var inflater:LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return  lstProfesors.size
    }

    override fun getItem(position: Int): Profesor {
        return lstProfesors[position]
    }

    override fun getItemId(position: Int): Long {
        return lstProfesors[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = inflater.inflate(R.layout.row_layout, null)

        rowView.txt_row_id.text = lstProfesors[position].id.toString()
        rowView.txt_name.text = lstProfesors[position].name.toString()



        rowView.setOnClickListener {
            edt_id.setText(rowView.txt_row_id.text.toString())
            edt_name.setText(rowView.txt_name.text.toString())
            edt_email.setText(rowView.txt_email.text.toString())
        }
        return rowView
    }
}