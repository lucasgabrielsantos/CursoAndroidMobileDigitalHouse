package br.com.digitalhouse.projectkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.projectkotlin.R
import kotlinx.android.synthetic.main.itemlista_layout.view.*

class RecyclerViewAdapter(val list: List<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itemlista_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val nome: String = list.get(position)
        holder.onBind(nome)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(nome: String) {
            itemView.text.text = nome
        }
    }
}









