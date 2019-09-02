package br.com.digitalhouse.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_id);
        button = findViewById(R.id.botao_main);
        editText = findViewById(R.id.edit_text_nome);

        final Editable nome = editText.getText();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), nome.toString(), Toast.LENGTH_LONG).show();

            }
        });

    }

    public void mostrarNome(String nomeUser){
        //Toast.makeText(getApplicationContext(),"Olá usuário " + nomeUser )
    }
}
