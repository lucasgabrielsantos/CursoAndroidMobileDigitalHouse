package br.com.digitalhouse.consultavalor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText preco;
    EditText porcentagem;
    double n1, n2, resultado, resultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preco = (EditText) findViewById(R.id.Preco);
        porcentagem = (EditText) findViewById(R.id.Porcentagem);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                n1 = Double.parseDouble(preco.getText().toString());
                n2 = Double.parseDouble(porcentagem.getText().toString());
                resultado = (n1 * n2) / 100;
                resultado2 = n1 - resultado;
                Toast.makeText(getApplicationContext(), "Valor a pagar " + resultado2, Toast.LENGTH_LONG).show();
            }
        });
    }
}
