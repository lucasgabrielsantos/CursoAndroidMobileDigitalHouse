package br.com.digitalhouse.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText num1, num2, result;
    Button btSomar, btSubtrair, btDividir, btMultiplicar;
    double n1, n2, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pegando os valores do usuário
        num1 = (EditText) findViewById(R.id.numero01);
        num2 = (EditText) findViewById(R.id.numero02);
        result = (EditText) findViewById(R.id.resultado);

        btSomar = (Button) findViewById(R.id.somar);
        btSubtrair = (Button) findViewById(R.id.menos);
        btDividir = (Button) findViewById(R.id.divisao);
        btMultiplicar = (Button) findViewById(R.id.multiplicar);

        //BOTÃO SOMAR
        btSomar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Passando os valores do layout para as vars da classe
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());

                resultado = n1 + n2;

                //Passando os valores da soma para o campo Resultado do layout
                result.setText(String.valueOf(resultado));
            }
        });
        //BOTÃO MENOS
        btSubtrair.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Passando os valores do layout para as vars da classe
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());

                resultado = n1 - n2;

                //Passando os valores da soma para o campo Resultado do layout
                result.setText(String.valueOf(resultado));
            }
        });

        //BOTÃO DIVIDIR
        btDividir.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Passando os valores do layout para as vars da classe
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());

                resultado = n1 / n2;

                //Passando os valores da soma para o campo Resultado do layout
                result.setText(String.valueOf(resultado));
            }
        });

        //BOTÃO MULTIPLICAR
        btMultiplicar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Passando os valores do layout para as vars da classe
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());

                resultado = n1 * n2;

                //Passando os valores da soma para o campo Resultado do layout
                result.setText(String.valueOf(resultado));
            }
        });
    }
}