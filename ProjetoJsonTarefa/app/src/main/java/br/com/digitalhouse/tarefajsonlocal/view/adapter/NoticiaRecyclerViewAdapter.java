package br.com.digitalhouse.tarefajsonlocal.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.tarefajsonlocal.R;
import br.com.digitalhouse.tarefajsonlocal.model.Noticia;


public class NoticiaRecyclerViewAdapter extends RecyclerView.Adapter<NoticiaRecyclerViewAdapter.ViewHolder> {
    private List<Noticia> listaNoticia = new ArrayList<>();

    public NoticiaRecyclerViewAdapter(List<Noticia> listaNoticia) {
        this.listaNoticia = listaNoticia;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Noticia noticia = listaNoticia.get(position);
        holder.onBind(noticia);
    }

    public void update(List<Noticia> listanoticias) {
        this.listaNoticia.clear();
        this.listaNoticia = listanoticias;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaNoticia.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitulo;
        private TextView textViewDescricao;
        private TextView textViewData;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.textViewTitle);
            textViewDescricao = itemView.findViewById(R.id.textViewDescricao);
            textViewData = itemView.findViewById(R.id.textViewData);
        }

        public void onBind(Noticia noticia) {
            textViewTitulo.setText(noticia.getTitle());
            textViewDescricao.setText(noticia.getDescription());
            textViewData.setText(noticia.getDate());
        }
    }
}
