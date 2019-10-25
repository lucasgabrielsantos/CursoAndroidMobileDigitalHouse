package br.com.digitalhouse.padraoarquiteturavalormvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
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

        initViews();



    }





    public void initViews(){
        textView = findViewById(R.id.textViewValor);
        button = findViewById(R.id.buttonValor);
        viewModel = ViewModel;

    }
}
