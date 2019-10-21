package com.example.agendatelefonica.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.agendatelefonica.R;
import com.example.agendatelefonica.adapters.AdapterLista;
import com.example.agendatelefonica.data.Database;
import com.example.agendatelefonica.data.PessoaDao;
import com.example.agendatelefonica.models.Pessoa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ListaActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputTelefone;
    private FloatingActionButton btnAdd;
    private RecyclerView recyclerLista;
    private AdapterLista adapterLista;
    private List<Pessoa> listaPessoas = new ArrayList<>();
    private PessoaDao pessoaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        initViews();
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerLista.setAdapter(adapterLista);
        recyclerLista.setLayoutManager(linearLayout);

        btnAdd.setOnClickListener(view -> {
            String nome = inputNome.getEditText().getText().toString();
            String telefone = inputTelefone.getEditText().getText().toString();

            new Thread(() -> {
                Pessoa pessoa = new Pessoa(nome, telefone);

                if (pessoa != null ){
                    pessoaDao.inserePessoa(pessoa);
                    buscaPessoas();
                }
            }).start();

            buscaPessoas();

        });


    }
    private void initViews(){
        inputNome = findViewById(R.id.inputNome);
        inputTelefone = findViewById(R.id.inputTelefone);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerLista = findViewById(R.id.recycerListas);
        adapterLista = new AdapterLista(listaPessoas);
        pessoaDao = Database.getDatabase(this).pessoaDao();
    }

    private void buscaPessoas(){
        pessoaDao.getAllPessoas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pessoas -> {
                    adapterLista.atualizaListaPessoas(pessoas);
                }, throwable -> {
                    Log.i("TAG", "método Lista" + throwable.getMessage());
                        }
                );
    }
}
