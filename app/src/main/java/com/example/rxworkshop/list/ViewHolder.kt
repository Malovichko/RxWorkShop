package com.example.rxworkshop.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.rxworkshop.R
import com.example.rxworkshop.data.DataModel

class ViewHolder constructor(private val staffView: View) :
    RecyclerView.ViewHolder(staffView) {

    private lateinit var textID: TextView
    private lateinit var textName: TextView

    fun bind(model: DataModel) {
        textID = staffView.findViewById(R.id.id_number)
        textName = staffView.findViewById(R.id.id_number)

        textID.text = model.ID.toString()
        textName.text = model.name
    }
}