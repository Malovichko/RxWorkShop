package com.example.rxworkshop.present.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxworkshop.R
import com.example.rxworkshop.domain.model.DataModel

class ViewHolder constructor(private val staffView: View, private val onClick: (id: Int) -> Unit) :
    RecyclerView.ViewHolder(staffView) {

    private lateinit var textID: TextView
    private lateinit var textName: TextView

    fun bind(model: DataModel) {
        textID = staffView.findViewById(R.id.id_number)
        textName = staffView.findViewById(R.id.id_number)

        textID.text = model.ID.toString()
        textName.text = model.name

        staffView.setOnClickListener{
            onClick(model.ID)
        }
    }
}