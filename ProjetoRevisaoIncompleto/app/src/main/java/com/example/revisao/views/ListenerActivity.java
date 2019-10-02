package com.example.revisao.views;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.revisao.R;
import com.example.revisao.model.Musica;

import java.util.List;

public class ListenerActivity extends AppCompatActivity {

    private static final String CANTOR_KEY = "cantor" ;
    private TextView cantor;
    private TextView nomemusica;
    private TextView nomeletra;
    private List<Musica> listaMusicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);

        initViews();
        inicializarVariaveis();

        if (getIntent() != null && getIntent().getExtras() != null) {
            String nomecantor = getIntent().getStringExtra(CANTOR_KEY);
            //Drawable drawable = getResources().getDrawable(musica.getText());

            Musica musica = buscaMusicaPeloAutor(nomecantor);

            if (musica != null) {
                nomemusica.setText(musica.getNomemusica());
                cantor.setText(musica.getNomecantor());
                nomeletra.setText(musica.getLetradamusica());

            }
        }
    }


    private Musica buscaMusicaPeloAutor(String nomeAutor) {
        for (Musica musica : listaMusicas) {
            if (musica.getNomecantor().equals(nomeAutor)) {
                return musica;
            }
        }
        return null;
    }

    public void initViews() {
        cantor = findViewById(R.id.nomecantor);
        nomemusica = findViewById(R.id.nomedamusica);
        nomeletra = findViewById(R.id.letradamusica);
    }

    private void inicializarVariaveis() {
        listaMusicas = new Musica().retornarListaMusica();
    }
}