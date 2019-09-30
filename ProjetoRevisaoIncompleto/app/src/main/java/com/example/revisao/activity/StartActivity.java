package com.example.revisao.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.revisao.R;
import com.google.android.material.textfield.TextInputLayout;

public class StartActivity extends AppCompatActivity {

    private static final String NOME_KEY = "nome";
    private TextInputLayout inputNome;
    private Button btnEnviar;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();

        //Implementar a lógica de ação do botão enviar

        inputNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacampo();
            }
        });
    }

    private void initView() {
        inputNome = findViewById(R.id.textInputLayoutNome);
        btnEnviar = findViewById(R.id.btnEnviar);
    }

//    //Implementar o a lógica do método de envio de dados para activity
//    private void enviaNomeActivity(String nome) {
//
//
//    }


    public void telaWelcome() {
        Intent intentbemvindo = new Intent(StartActivity.this, WelcomeActivity.class);
        Bundle bundle = new Bundle();
        intentbemvindo.putExtra(NOME_KEY, nome);
        intentbemvindo.putExtras(bundle);
        startActivity(intentbemvindo);
        //finish();
    }

    public void validacampo() {
        inputNome.setErrorEnabled(false);

        nome = inputNome.getEditText().getText().toString().trim();

        if (nome.isEmpty()) {
            inputNome.setError("Campo vazio. ");
            vibrar(400);

            return;
        } else {
            telaWelcome();
        }
    }

    private void vibrar(int i) {
        Vibrator rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long milliseconds = 30;
        rr.vibrate(milliseconds);
    }
}


