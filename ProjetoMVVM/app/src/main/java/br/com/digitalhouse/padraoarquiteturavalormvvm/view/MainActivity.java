package br.com.digitalhouse.padraoarquiteturavalormvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.digitalhouse.padraoarquiteturavalormvvm.R;
import br.com.digitalhouse.padraoarquiteturavalormvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewValor);
        button = findViewById(R.id.buttonValor);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        button.setOnClickListener(v -> {

            viewModel.somaValor(5);

            viewModel.retornaValor().observe(this,valorRetornado ->{
                textView.setText(valorRetornado.toString());
            });
        });


    }
}
