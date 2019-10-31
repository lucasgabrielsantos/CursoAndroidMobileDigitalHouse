package br.com.digitalhouse.projetoretrofitfilmes.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.projetoretrofitfilmes.R;
import br.com.digitalhouse.projetoretrofitfilmes.model.Result;
import br.com.digitalhouse.projetoretrofitfilmes.view.adapter.RecyclerViewAdapter;
import br.com.digitalhouse.projetoretrofitfilmes.viewmodel.ViewModelFilme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewAdapter adapter;
    private List<Result> listaFilmes = new ArrayList<>();
    private ViewModelFilme viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getAllFilmes("bde8033d3274c91b292a5293c6349052");

        viewModel.getListaFilme().observe(this, resultaLista -> {
            adapter.atualizaLista(resultaLista);
        });

        viewModel.loading().observe(this, loading -> {
            if (loading){
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recyclerViewFilmes);
        progressBar = findViewById(R.id.progress_bar);
        adapter = new RecyclerViewAdapter(listaFilmes);
        viewModel = ViewModelProviders.of(this).get(ViewModelFilme.class);
    }
}
