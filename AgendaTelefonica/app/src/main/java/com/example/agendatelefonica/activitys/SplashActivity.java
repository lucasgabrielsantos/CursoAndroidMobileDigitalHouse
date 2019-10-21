package com.example.agendatelefonica.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.agendatelefonica.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(() -> mostrarActivity(), 1000);

    }
    private void mostrarActivity(){
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
        finish();
    }
}
