package br.com.digitalhouse.splash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView imgSplash;
    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgSplash = findViewById(R.id.imageView);

        imgSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump();
            }
        });

        //chamada do método que  irá temporizar a duração da tela de splash
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 3000);
    }

    //Método que vai para a tela de Home através de uma Intent
    private void jump(){
        timer.cancel();
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        finish();

    }
}
