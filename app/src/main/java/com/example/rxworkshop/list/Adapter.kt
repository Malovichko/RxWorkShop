package com.example.rxworkshop.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxworkshop.R
import com.example.rxworkshop.data.DataModel

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    private var itemList = listOf<DataModel>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(itemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_example, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    fun setUpStaffList(list: List<DataModel>) {
        itemList = list
        notifyDataSetChanged()
    }
}