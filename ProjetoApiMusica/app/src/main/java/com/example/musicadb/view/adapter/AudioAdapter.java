package com.example.musicadb.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicadb.R;
import com.example.musicadb.pojo.Album;
import com.example.musicadb.pojo.Artista;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder> {

    private List<Album> listaArtista;

    public AudioAdapter(List<Album> listaArtista) {
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
        final Album filmeartista = listaArtista.get(position);
        holder.onBind(filmeartista);
    }

    @Override
    public int getItemCount() {
        return listaArtista.size();
    }

    public void atualizaLista(List<Album> resultaLista){

        if(this.listaArtista.isEmpty()){
            this.listaArtista = listaArtista;
        }else{
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

        public void onBind(Album musica) {

            Picasso.get().load("https://www.theaudiodb.com/images/media/artist/thumb/uxrqxy1347913147.jpg" + musica.getStrAlbum()).into(imageView);

            textView.setText(musica.getIdAlbum());
        }
    }
}
