package com.example.revisao.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.Interface.RecyclerViewOnClick;
import com.example.revisao.R;
import com.example.revisao.adapter.MusicAdapter;
import com.example.revisao.model.Musica;
import com.example.revisao.views.ListenerActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicaBandaFragment extends Fragment implements RecyclerViewOnClick {

    private static final String CANTOR_KEY = "cantor" ;
    private RecyclerView recyclerView;
    private MusicAdapter adapter;
    private List<Musica> listaMusicas;


    public MusicaBandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_musica_banda, container, false);

        inicializarVariaveis();

        recyclerView = view.findViewById(R.id.listamusicas);

        adapter = new MusicAdapter(listaMusicas,this);

        //Setando o tipo de layout da lista (nesse exemplo será uma lista vertical)
        recyclerView.setAdapter(adapter);

        //Definição do layout da lista utilizando a classe LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void OnClick(Musica musica) {
        Intent intent = new Intent(getActivity(), ListenerActivity.class);
        intent.putExtra(CANTOR_KEY,musica.getNomecantor());
        startActivity(intent);
    }

    private void inicializarVariaveis() {
        listaMusicas = new Musica().retornarListaMusica();
    }
}

