package com.example.mydiary

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiary.data.Line

class ListAdapter(): RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var lineList = emptyList<Line>()
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var textview1:TextView=view.findViewById(R.id.entry_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layout=LayoutInflater.from(parent.context).inflate(R.layout.history_text,parent,false)
        return MyViewHolder(layout)

    }

    override fun getItemCount(): Int {
        return lineList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = lineList[0].line_text
        Log.d("stg", "${currentItem.toString()} ")


        holder.textview1.text=currentItem

    }
    fun setData(line: List<Line>){
        this.lineList = line
        notifyDataSetChanged()
    }


}