package com.example.revisao.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.R;
import com.example.revisao.adapter.MusicAdapter;
import com.example.revisao.model.Musica;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicaBandaFragment extends Fragment {

    private RecyclerView recyclerView;
    private MusicAdapter adapter;
    private List<Musica> listaMusica = new ArrayList<>();


    public MusicaBandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_musica_banda, container, false);


        recyclerView = view.findViewById(R.id.listamusicas);

        adapter = new MusicAdapter(retornarListaMusica());

        //Setando a adapter no componente do recyclerView

        //Setando o tipo de layout da lista (nesse exemplo será uma lista vertical)
        recyclerView.setAdapter(adapter);

        //Definição do layout da lista utilizando a classe LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }


    //Método que retorna uma lista de contatos
    public List<Musica> retornarListaMusica() {

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

