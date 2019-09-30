package com.example.revisao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.revisao.R;
import com.example.revisao.fragment.BandaFragment;
import com.example.revisao.fragment.ComidaFragment;
import com.example.revisao.fragment.MusicaBandaFragment;
import com.google.android.material.navigation.NavigationView;

//Implemetar a interface Comunicador e sobrescrever seu respectivo método
public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    private Button btnsair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnsair = findViewById(R.id.action_sair);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        //Fazer a instancia da ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        //Setar o addDrawerListener no drawer
        drawer.addDrawerListener(toggle);

        //Invocar o método syncState() através do toggle
        toggle.syncState();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_music, R.id.nav_food,R.id.banda_id, R.id.action_sair)
                .setDrawerLayout(drawer)
                .build();

        //Implementar a lógica do setNavigationItemSelectedListener através do navigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //Criação de uma variavel que vai receber o id do item selecionado
                int id = menuItem.getItemId();

                //Verifica se o id recebido é igual ao do layout e realiza uma ação
                if (id == R.id.nav_music) {

                    //Faço o replace do fragmento de Home quando clicar no botão de Home
                    replaceFragment(new BandaFragment());
                } else if (id == R.id.nav_food) {

                    //Faço o replace do fragmento de Galeria quando clicar no botão de Galeria
                    replaceFragment(new ComidaFragment());

                } else if (id == R.id.nav_banda) {

                    //Faço o replace do fragmento de Galeria quando clicar no botão de Galeria
                    replaceFragment(new MusicaBandaFragment());

                }

                //chama a ação de close do drawerLayout e mover a gaveta para direita
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    //Sobreescrever o método onBackPressed e implementar a lógica
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        return true;
    }

    //Sobreescrever o método onOptionsItemSelected e implementar a lógica

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_sair:
                getMenuInflater();
                startActivity(new Intent(this, StartActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //Desenvolver e implementar o método replaceFragment
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
