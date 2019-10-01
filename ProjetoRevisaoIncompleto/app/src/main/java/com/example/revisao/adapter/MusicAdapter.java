package com.example.revisao.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.R;
import com.example.revisao.model.Musica;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder>{

    private List<Musica> listaMusica;

    public MusicAdapter(List<Musica> listaMusica) {
        this.listaMusica = listaMusica;
    }


    //Método que infla o layout do item e retorna uma nova instancia da classe ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_music,viewGroup, false);
        return new ViewHolder(view);
    }
    //Método que possui um objeto que recebe o valor de acordo com a posição da lista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {
        Musica musica = listaMusica.get(posicao);

        //chama o método onBind a partir do viewHolder passando o objeto como parametro
        viewHolder.onBind(musica);
    }

    //Método que retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return listaMusica.size();
    }

    //CLASSE A VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Declaração dos componentes
        private TextView txtNomeBanda;
        private TextView txtNomeMusica;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            
            txtNomeBanda = itemView.findViewById(R.id.banda_id);
            txtNomeMusica = itemView.findViewById(R.id.musica_id);
        }

        //Método que seta as informações nos componentes
        public void onBind(Musica musica){

            txtNomeBanda.setText(musica.getNomecantor());
            txtNomeMusica.setText(musica.getNomemusica());


        }
    }
}