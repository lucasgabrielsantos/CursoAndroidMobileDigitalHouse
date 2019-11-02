package br.com.digitalhouse.projetofilmespopularesapi.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import br.com.digitalhouse.projetofilmespopularesapi.R;
import br.com.digitalhouse.projetofilmespopularesapi.model.Result;

import static br.com.digitalhouse.projetofilmespopularesapi.view.activity.MainActivity.DESCRIPTION_KEY;
import static br.com.digitalhouse.projetofilmespopularesapi.view.activity.MainActivity.FILME_KEY;

public class DetalheFilmesPopularesActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewTitulo;
    private TextView textViewDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filmes_populares);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {

            Result result = getIntent().getExtras().getParcelable(FILME_KEY);
            Result result1 = getIntent().getExtras().getParcelable(DESCRIPTION_KEY);
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + result.getPosterPath()).into(imageView);
            textViewTitulo.setText(result.getTitle());
            textViewDetalhe.setText(result1.getOverview());

        }
    }


    public void initViews() {

        imageView = findViewById(R.id.imgFilmeDetalhe);
        textViewTitulo = findViewById(R.id.txtTituloDetalhe);
        textViewDetalhe = findViewById(R.id.texViewDetalhe);

    }
}
