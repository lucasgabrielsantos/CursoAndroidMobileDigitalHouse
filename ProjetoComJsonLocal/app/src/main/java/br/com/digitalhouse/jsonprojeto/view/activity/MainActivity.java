package br.com.digitalhouse.jsonprojeto.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.jsonprojeto.R;
import br.com.digitalhouse.jsonprojeto.model.Noticia;
import br.com.digitalhouse.jsonprojeto.view.adapter.RecyclerViewAdapter;
import br.com.digitalhouse.jsonprojeto.viewmodel.NoticiaViewModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private NoticiaViewModel viewModel;
    private List<Noticia> noticias = new ArrayList<>();
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.buscaNoticias();

        viewModel.retornaNoticias().observe(this, noticiasRetornada -> {
            adapter.update(noticiasRetornada);
        });

        viewModel.retornaValorLoading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else
                progressBar.setVisibility(View.GONE);
        });
    }


    public void initView() {
        recyclerView = findViewById(R.id.recyclernoticias);
        progressBar = findViewById(R.id.progressBar);
        viewModel = ViewModelProviders.of(this).get(NoticiaViewModel.class);
        adapter = new RecyclerViewAdapter(noticias);
    }
}
