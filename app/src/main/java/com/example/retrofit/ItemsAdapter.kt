package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val itemsList:List<DataItemsItem>):RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=itemsList[position]

        holder.title.text=item.title
        holder.id.text=item.userId.toString()
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val title:TextView=itemView.findViewById(R.id.title)
        val id:TextView=itemView.findViewById(R.id.userid)
    }
}