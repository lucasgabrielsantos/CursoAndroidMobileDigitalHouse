package br.com.digitalhouse.marvel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    Button button;
    TextView textViewnome;
    TextView textViewemail;
    TextView textViewend;
    TextView textViewprof;



    EditText editTextnome;
    EditText editTextemail;
    EditText editTextend;
    EditText editTextprof;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.cadastroid);
        editTextnome = findViewById(R.id.text2);
        textViewemail = findViewById(R.id.edit_text_email);
        editTextemail = findViewById(R.id.text3);
        textViewend = findViewById(R.id.edit_text_end);
        editTextend = findViewById(R.id.text4);
        textViewprof = findViewById(R.id.edit_text_prof);
        editTextprof = findViewById(R.id.text5);
        button = findViewById(R.id.botao_main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewnome.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Preencher nome.", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}
