package com.example.revisao.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.revisao.R;

public class WelcomeActivity extends AppCompatActivity {
    public static final String NOME_KEY = "nome";

    private TextView txtBoasVindas;
    private Button btnComecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initViews();

        //Implementar a lógica de recebimento de dados e setar o nome no textView

        //Criando uma nova instancia do tipo Intent
        Intent intent = getIntent();

        //Variavel do tipo bundle que recebe as informações vindas do Intent
        Bundle bundle = intent.getExtras();

        //Atribuição dos valores recebidos da outra activity para as variáveis através do bundle.getString e a constante para referenciar o valor
        String nome = bundle.getString(NOME_KEY);
        txtBoasVindas.setText("Seja bem-vindo "+ nome + " Esse é um app de revisão!");


        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                finish();
            }
        });
    }


    private void initViews() {
        txtBoasVindas = findViewById(R.id.textViewBemVindo);
        btnComecar = findViewById(R.id.btnComecar);
    }
}
