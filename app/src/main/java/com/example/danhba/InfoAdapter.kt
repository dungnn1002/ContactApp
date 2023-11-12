package com.example.danhba

import android.app.Activity
import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InfoAdapter(private val context: Context, private val listinfo: List<Info>) : RecyclerView.Adapter<InfoAdapter.InfoHolder>() {

    var onItemClick : ((Info)->Unit)? = null;
    inner class InfoHolder(itemView : View): RecyclerView.ViewHolder(itemView),View.OnCreateContextMenuListener{
        var infoPhone : TextView = itemView.findViewById(R.id.phone)
        var infoImage : TextView = itemView.findViewById(R.id.imagealphabet)
        init {
            itemView.setOnCreateContextMenuListener(this)
        }
        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            val inflater: MenuInflater = (context as Activity).menuInflater
            inflater.inflate(R.menu.menu, menu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.info,parent,false)
        return InfoHolder(view)
    }

    override fun getItemCount(): Int {
        return listinfo.size
    }

    override fun onBindViewHolder(holder: InfoHolder, position: Int) {
        val app = listinfo[position]
        holder.infoPhone.text = app.name
        holder.infoImage.text = app.name.first().toString()
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(app)
            println("Hello")
        }

    }

}
