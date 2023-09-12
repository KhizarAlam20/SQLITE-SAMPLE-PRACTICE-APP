package com.example.sqllite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import detailClass

class rcvAdapters(val context: Context, val detail: ArrayList<detailClass>) :
    RecyclerView.Adapter<rcvAdapters.exampleViewHolder>() {

    class exampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rcvName: TextView = itemView.findViewById(R.id.rcvName)
        val rcvMail: TextView = itemView.findViewById(R.id.rcvMail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): exampleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item, parent,
                false
            )
        return exampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: exampleViewHolder, position: Int) {
        holder.rcvName.text = detail[position].name
        holder.rcvMail.text = detail[position].mail
    }

    override fun getItemCount(): Int {
        return detail.size;
    }
}