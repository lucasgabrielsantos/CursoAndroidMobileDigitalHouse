package com.example.musicadb.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.musicadb.R;
import com.example.musicadb.pojo.Artist;
import com.example.musicadb.view.adapter.AudioAdapter;
import com.example.musicadb.viewmodel.ViewModelMusica;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AudioAdapter adapter;
    private List<Artist> listamusica = new ArrayList<>();
    private ViewModelMusica viewModelMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModelMusica.getAllAlbuns("195003/");

        viewModelMusica.getListaAlbum().observe(this, resultaLista -> {
            adapter.atualizaLista(resultaLista);
        });

        viewModelMusica.loading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    public void initViews(){

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);
        adapter = new AudioAdapter(listamusica);
        viewModelMusica = ViewModelProviders.of(this).get(ViewModelMusica.class);

    }
}
