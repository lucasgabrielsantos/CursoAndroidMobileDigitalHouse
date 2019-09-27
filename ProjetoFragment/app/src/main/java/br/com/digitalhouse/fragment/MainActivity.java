package br.com.digitalhouse.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnbarca;
    private Button btnreal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnbarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recarregaFragment(new BarcelonaFragment());
            }
        });
        btnreal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recarregaFragment(new RealFragment());
            }
        });
    }

    public void initViews() {
        btnbarca = findViewById(R.id.barca);
        btnreal = findViewById(R.id.real);
    }

    public void recarregaFragment(Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();

    }
}
