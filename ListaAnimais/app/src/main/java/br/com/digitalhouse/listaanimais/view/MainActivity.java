package br.com.digitalhouse.listaanimais.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.listaanimais.Interface.RecyclerViewOnClick;
import br.com.digitalhouse.listaanimais.R;
import br.com.digitalhouse.listaanimais.adapter.AnimalAdapter;
import br.com.digitalhouse.listaanimais.model.Animal;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClick {

    private static final String ANIMAL_KEY = "animal";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Animal> listaAnimal = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewAnimais);

        adapter = new AnimalAdapter(retornarListaAnimal(), this);

        recyclerView.setAdapter(adapter);

        //Setando o tipo de layout da lista (nesse exemplo será uma lista verticar)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Animal> retornarListaAnimal() {

        listaAnimal.add(new Animal("Cachorro", R.drawable.cachorro));
        listaAnimal.add(new Animal("Gato", R.drawable.gato));
        listaAnimal.add(new Animal("Leao", R.drawable.leao));


        return listaAnimal;
    }

    @Override
    public void OnClick(Animal animal) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ANIMAL_KEY, animal);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}


