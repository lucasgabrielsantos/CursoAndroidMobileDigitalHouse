package br.com.digitalhouse.projetoretrofitfilmes.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.projetoretrofitfilmes.R;
import br.com.digitalhouse.projetoretrofitfilmes.model.Result;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Result> listaFilme = new ArrayList<>();

    public RecyclerViewAdapter(List<Result> listaFilmes) {
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Result filme = listaFilme.get(position);
        holder.onBind(filme);
    }

    @Override
    public int getItemCount() {
        return listaFilme.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgFilme);
            textView = itemView.findViewById(R.id.txtTitulo);

        }

        public void onBind(Result filme) {

            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filme.getPosterPath()).into(imageView);

            textView.setText(filme.getTitle());

        }
    }

    public void atualizaLista(List<Result> resultaLista) {

        this.listaFilme.clear();
        this.listaFilme = resultaLista;
        notifyDataSetChanged();
    }

}
