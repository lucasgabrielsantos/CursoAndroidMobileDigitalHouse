package br.com.digitalhouse.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button botaofinal = (Button) findViewById(R.id.button);

        botaofinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent main4 = new Intent(Main4Activity.this, Main4Activity.class);
                startActivity(main4);

                Toast.makeText(getApplicationContext(), "EU CONSEGUI", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
