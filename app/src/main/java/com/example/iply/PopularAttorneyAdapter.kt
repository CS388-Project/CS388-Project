package com.example.iply

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PopularAttorneyAdapter(private val attorneys: List<Attorney>) :
    RecyclerView.Adapter<PopularAttorneyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val textView: TextView = view.findViewById(R.id.item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val attorney = attorneys[position]
        holder.textView.text = attorney.name
        holder.imageView.setImageResource(attorney.imageResId) // 로컬 이미지
    }

    override fun getItemCount(): Int = attorneys.size
}
