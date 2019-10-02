package br.com.digitalhouse.listaanimais.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.listaanimais.R;
import br.com.digitalhouse.listaanimais.model.Animal;

public class HomeActivity extends AppCompatActivity {

    private static final String ANIMAL_KEY = "animal";
    private ImageView imagem;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        if (getIntent() != null && getIntent().getExtras() != null) {
            Animal animal = getIntent().getExtras().getParcelable(ANIMAL_KEY);
            Drawable drawable = getResources().getDrawable(animal.getImagem());
            imagem.setImageDrawable(drawable);
            textView.setText(animal.getNome());
        }
    }

    public void initViews(){
        imagem = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);

    }
}
