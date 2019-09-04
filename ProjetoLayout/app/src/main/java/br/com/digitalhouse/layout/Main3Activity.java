package br.com.digitalhouse.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button botao01 = (Button) findViewById(R.id.botao01);

        botao01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent main4 = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(main4);
            }
        });
    }
}
