package br.com.digitalhouse.projetofilmespopularesapi.view.adapter;

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

import br.com.digitalhouse.projetofilmespopularesapi.R;
import br.com.digitalhouse.projetofilmespopularesapi.model.Result;
import br.com.digitalhouse.projetofilmespopularesapi.view.Interface.OnClickDetalhe;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Result> listFilmesPop;
    private OnClickDetalhe listener;

    public RecyclerViewAdapter(List<Result> listaFilmesPop, OnClickDetalhe listener) {
        this.listFilmesPop = listaFilmesPop;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result filmepopular = listFilmesPop.get(position);
        holder.onBind(filmepopular);

        holder.itemView.setOnClickListener(v -> {
            listener.onClick(filmepopular);
        });
    }

    @Override
    public int getItemCount() {
        return listFilmesPop.size();
    }

    public void atualizalista(List<Result> resultList) {
        this.listFilmesPop.clear();
        this.listFilmesPop = resultList;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgFilme);
            textView = itemView.findViewById(R.id.txtTitulo);
        }

        public void onBind(Result filmepopular) {

            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filmepopular.getPosterPath()).into(imageView);

            textView.setText(filmepopular.getTitle());
        }
    }
}
