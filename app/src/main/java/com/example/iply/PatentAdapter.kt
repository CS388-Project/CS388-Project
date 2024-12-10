package com.example.iply

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PatentAdapter(private var patentList: List<Patent>) :
    RecyclerView.Adapter<PatentAdapter.PatentViewHolder>() {

    class PatentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.findViewById<TextView>(R.id.item_name)
        val itemImage = itemView.findViewById<ImageView>(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return PatentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PatentViewHolder, position: Int) {
        val patent = patentList[position]
        holder.itemName.text = patent.name
        holder.itemImage.setImageResource(patent.imageResId)
    }

    override fun getItemCount(): Int = patentList.size

    fun updateData(newList: List<Patent>) {
        patentList = newList
        notifyDataSetChanged()
    }
}
