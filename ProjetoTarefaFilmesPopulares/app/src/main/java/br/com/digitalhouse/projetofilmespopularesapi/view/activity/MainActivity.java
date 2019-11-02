package br.com.digitalhouse.projetofilmespopularesapi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Destroyable;

import br.com.digitalhouse.projetofilmespopularesapi.R;
import br.com.digitalhouse.projetofilmespopularesapi.model.Result;
import br.com.digitalhouse.projetofilmespopularesapi.view.Interface.OnClickDetalhe;
import br.com.digitalhouse.projetofilmespopularesapi.view.adapter.RecyclerViewAdapter;
import br.com.digitalhouse.projetofilmespopularesapi.viewmodel.ViewModelFilmesPopulares;

public class MainActivity extends AppCompatActivity implements OnClickDetalhe {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewAdapter adapter;
    private List<Result> listaFilmesPop = new ArrayList<>();
    private ViewModelFilmesPopulares viewModel;
    public static final String FILME_KEY = "filme";
    public static final String DESCRIPTION_KEY = "descricao";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.GetAllFilmesPopulares("bde8033d3274c91b292a5293c6349052");

        viewModel.getListaFilmePopular().observe(this, resultaLista -> {
            adapter.atualizalista(resultaLista);
        });

        viewModel.loading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

    }


    public void initViews() {

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        adapter = new RecyclerViewAdapter(listaFilmesPop, this);
        viewModel = ViewModelProviders.of(this).get(ViewModelFilmesPopulares.class);
    }

    @Override
    public void onClick(Result result) {
        Intent intent = new Intent(MainActivity.this, DetalheFilmesPopularesActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(FILME_KEY, result);
        bundle.putParcelable(DESCRIPTION_KEY, result);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
