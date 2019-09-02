package br.com.digitalhouse.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.botao_main);
        Log.i("cicloDeVida","Metodo onCreate");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "CONSEGUIU", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("cicloDeVida", "Metodo onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("cicloDeVida","Metodo onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("cicloDeVida","Metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("cicloDeVida","Metodo onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("cicloDeVida","Metodo onDestroy");
    }

}
