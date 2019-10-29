package br.com.digitalhouse.tarefajsonlocal.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import br.com.digitalhouse.tarefajsonlocal.R;
import br.com.digitalhouse.tarefajsonlocal.model.Noticia;
import br.com.digitalhouse.tarefajsonlocal.view.adapter.NoticiaRecyclerViewAdapter;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private br.com.digitalhouse.tarefajsonlocal.viewmodel.NoticiaViewModel viewModel;
    private List<Noticia> noticias = new ArrayList<>();
    private NoticiaRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclernoticias);
        progressBar = findViewById(R.id.progressBar);
        viewModel = ViewModelProviders.of(this).get(br.com.digitalhouse.tarefajsonlocal.viewmodel.NoticiaViewModel.class);
        adapter = new NoticiaRecyclerViewAdapter(noticias);
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

}
