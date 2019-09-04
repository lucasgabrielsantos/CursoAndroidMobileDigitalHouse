package br.com.digitalhouse.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button frame = (Button) findViewById(R.id.frame);

        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent main3 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(main3);

            }
        });
    }
}
