package br.com.digitalhouse.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button) findViewById(R.id.botao01);
        Button botao0 = (Button) findViewById(R.id.botao00);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent main2 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(main2);
            }
        });
        botao0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent main1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(main1);
            }
        });
    }
}