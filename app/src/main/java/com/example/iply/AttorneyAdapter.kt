package com.example.iply

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AttorneyAdapter(private var attorneyList: List<Attorney>) :
    RecyclerView.Adapter<AttorneyAdapter.AttorneyViewHolder>() {

    class AttorneyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.findViewById<TextView>(R.id.item_name)
        val itemImage = itemView.findViewById<ImageView>(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttorneyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return AttorneyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttorneyViewHolder, position: Int) {
        val attorney = attorneyList[position]
        holder.itemName.text = attorney.name
        holder.itemImage.setImageResource(attorney.imageResId)
    }

    override fun getItemCount(): Int = attorneyList.size

    fun updateData(newList: List<Attorney>) {
        attorneyList = newList
        notifyDataSetChanged()
    }
}
