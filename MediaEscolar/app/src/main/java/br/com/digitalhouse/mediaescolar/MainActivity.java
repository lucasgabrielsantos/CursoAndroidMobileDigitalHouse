package br.com.digitalhouse.mediaescolar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private Button btncalcular;
    private TextView resulttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Float nota01 = Float.parseFloat(editText1.getText().toString());
                Float nota02 = Float.parseFloat(editText2.getText().toString());
                Float nota03 = Float.parseFloat(editText3.getText().toString());
                Float nota04 = Float.parseFloat(editText4.getText().toString());

                Float media = calcularMedia(nota01, nota02, nota03, nota04);
                resulttext.setText("Nota final: " + media);
            }
        });
    }


    public Float calcularMedia(Float nota1, Float nota2, Float nota3, Float nota4) {
        Float media = (nota1 + nota2 + nota3 + nota4) / 4;

        return media;
    }


    public void initViews() {
        editText1 = findViewById(R.id.nota01_edittext);
        editText2 = findViewById(R.id.nota02_edittext);
        editText3 = findViewById(R.id.nota03_edittext);
        editText4 = findViewById(R.id.nota04_edittext);
        btncalcular = findViewById(R.id.button);
        resulttext = findViewById(R.id.result);
    }
}
