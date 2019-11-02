package br.com.digitalhouse.projetofilmespopularesapi.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.projetofilmespopularesapi.R;

public class SplashActivity extends AppCompatActivity {


    private ImageView imagemSplash;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imagemSplash = findViewById(R.id.imageView2);

            imagemSplash.setOnClickListener(view -> jump());

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    jump();
                }
            }, 3000);

        }
        private void jump() {
            timer.cancel();
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

