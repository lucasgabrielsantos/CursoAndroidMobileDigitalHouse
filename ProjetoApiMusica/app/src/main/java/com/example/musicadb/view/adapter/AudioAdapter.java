package com.example.musicadb.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicadb.R;
import com.example.musicadb.pojo.Loved;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder> {

    private List<Loved> listaArtista;

    public AudioAdapter(List<Loved> listaArtista) {
        this.listaArtista = listaArtista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Loved filmeartista = listaArtista.get(position);
        holder.onBind(filmeartista);
    }

    @Override
    public int getItemCount() {
        return listaArtista != null ? listaArtista.size() : 0;
    }

    public void atualizaLista(List<Loved> resultaLista) {

        if (this.listaArtista.isEmpty()) {
            this.listaArtista = resultaLista;
        } else {
            this.listaArtista.addAll(listaArtista);
        }
        notifyDataSetChanged();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgmusic);
            textView = itemView.findViewById(R.id.txtTitulo);
        }

        public void onBind(Loved musica) {

            Picasso.get().load(musica.getStrTrackThumb()).into(imageView);

            textView.setText(musica.getStrArtist());
        }
    }
}
