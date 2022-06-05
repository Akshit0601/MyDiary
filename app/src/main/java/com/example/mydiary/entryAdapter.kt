package com.example.mydiary

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView




class entryAdapter(private val item:MutableList<String>):RecyclerView.Adapter<entryAdapter.entryViewholder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): entryViewholder {

        val layout=LayoutInflater.from(parent.context).inflate(R.layout.entry_text,parent,false)

        return entryViewholder(layout,MyCustomEditTextListener())
    }



    override fun onBindViewHolder(holder: entryViewholder, position: Int){
        holder.myCustomEditTextListener.updatePosition(holder.adapterPosition)
        holder.edittxt.setText(item[holder.adapterPosition])

    }

    override fun getItemCount(): Int {
        return item.size
    }


    class entryViewholder(val view:View, myCustomEditTextListener: MyCustomEditTextListener):RecyclerView.ViewHolder(view){
        var edittxt:EditText
        var myCustomEditTextListener: MyCustomEditTextListener

        init {
            edittxt = view.findViewById(R.id.entry_text)
            this.myCustomEditTextListener = myCustomEditTextListener
            edittxt.addTextChangedListener(myCustomEditTextListener)

        }

    }
     inner class MyCustomEditTextListener:TextWatcher{
        private var position=0
        fun updatePosition(position:Int){
            this.position=position
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
        {
            item[position] = p0.toString()
            Log.d("mytag", "onTextChanged: ${item.get(1)}")


        }

        override fun afterTextChanged(p0: Editable?) {

        }


    }


}
