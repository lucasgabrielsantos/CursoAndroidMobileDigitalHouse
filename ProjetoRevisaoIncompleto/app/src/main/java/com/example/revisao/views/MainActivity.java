package com.example.revisao.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.revisao.R;
import com.example.revisao.adapter.MusicAdapter;
import com.example.revisao.model.Musica;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MusicAdapter adapter;
    private List<Musica> listaMusica = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listamusicas);

        adapter = new MusicAdapter(retornarListaMusica());

        //Setando a adapter no componente do recyclerView
        recyclerView.setAdapter(adapter);

        //Setando o tipo de layout da lista (nesse exemplo será uma lista verticar)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //Método que retorna uma lista de contatos
    public List<Musica> retornarListaMusica(){

        listaMusica.add(new Musica("SÓ MODÃO ", "------------------"));
        listaMusica.add(new Musica("Milionário e José Rico", "Boate Azul"));
        listaMusica.add(new Musica("Mateus e Kauan", "Quarta Cadeira"));
        listaMusica.add(new Musica("Chitãozinho e Xororó", "Evidências"));
        listaMusica.add(new Musica("Zé Neto e Cristiano", "Largado as Traças"));
        listaMusica.add(new Musica("Gusttavo Lima", "Cem Mil"));
        listaMusica.add(new Musica("Jorge e Mateus", "Paredes"));
        listaMusica.add(new Musica("João Mineiro a Marciano", "A Bailarina"));

        return listaMusica;
    }

}
