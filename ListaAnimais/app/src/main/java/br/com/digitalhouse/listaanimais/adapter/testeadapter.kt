//package br.com.digitalhouse.listaanimais.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import br.com.digitalhouse.listaanimais.Interface.RecyclerViewOnClick
//import br.com.digitalhouse.listaanimais.R
//import br.com.digitalhouse.listaanimais.model.Animal
//
//class AnimalAdapter(private val listaAnimais: List<Animal>, private val listener: RecyclerViewOnClick) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AnimalAdapter.ViewHolder {
//        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_lista, viewGroup, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(viewHolder: AnimalAdapter.ViewHolder, position: Int) {
//        val animal = listaAnimais[position]
//
//        viewHolder.onBind(animal)
//
//        viewHolder.itemView.setOnClickListener { listener.OnClick(animal) }
//    }
//
//    override fun getItemCount(): Int {
//        return listaAnimais.size
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        private val textnome: TextView
//        private val imagem: ImageView
//
//        init {
//
//            textnome = itemView.findViewById(R.id.textViewNome)
//            imagem = itemView.findViewById(R.id.imageView)
//        }
//
//        //Método que seta as informações nos componentes
//        fun onBind(animal: Animal) {
//            val drawable = itemView.resources.getDrawable(animal.imagem)
//            imagem.setImageDrawable(drawable)
//            textnome.text = animal.nome
//
//        }
//    }
//}
//
