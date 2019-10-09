package br.com.digitalhouse.projetobanda.views.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.projetobanda.R;
import br.com.digitalhouse.projetobanda.adapter.AlbumAdapter;
import br.com.digitalhouse.projetobanda.model.Album;
import br.com.digitalhouse.projetobanda.views.fragments.FotoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Album> albumList = new ArrayList<>();

        albumList.add(new Album("João Mineiro e Marciano",
                FotoFragment.novaInstancia(R.drawable.joaomineiro, "João Mineiro e Marciano")));
        albumList.add(new Album("João Carreiro e Capatazaz",
                FotoFragment.novaInstancia(R.drawable.capataz, "João Carreiro e Capataz")));
        albumList.add(new Album("R10",
                FotoFragment.novaInstancia(R.drawable.ronaldinho, "Ronaldinho")));

        AlbumAdapter adapter = new AlbumAdapter(getSupportFragmentManager(), albumList);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        viewPager.setOffscreenPageLimit(albumList.size());

        tabLayout.setupWithViewPager(viewPager);

    }
}
