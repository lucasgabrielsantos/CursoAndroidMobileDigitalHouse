package br.com.digitalhouse.projetofilmespopularesapi.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.digitalhouse.projetofilmespopularesapi.R;
import br.com.digitalhouse.projetofilmespopularesapi.model.Result;

import static br.com.digitalhouse.projetofilmespopularesapi.view.activity.MainActivity.FILME_KEY;

public class DetalheFilmesPopularesActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filmes_populares);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null){

            Result result = getIntent().getExtras().getParcelable(FILME_KEY);

            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + result.getPosterPath()).into(imageView);
            textView.setText(result.getTitle());

        }


    }




    public void initViews(){

        imageView = findViewById(R.id.imgFilmeDetalhe);
        textView = findViewById(R.id.txtTituloDetalhe);

    }
}
