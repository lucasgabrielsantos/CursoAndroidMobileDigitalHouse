package br.com.digitalhouse.projectkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.projectkotlin.R

class RecyclerViewAdapter(val list: List<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itemlista_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nome: String = list.get(position)
        holder.onBind(nome)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(nome: String) {

            itemView.findViewById<TextView>(R.id.text).text = nome
        }
    }
}









