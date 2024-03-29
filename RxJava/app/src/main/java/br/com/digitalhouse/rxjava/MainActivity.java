package br.com.digitalhouse.rxjava;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.digitalhouse.rxjava.adapters.UsuarioRecyclerViewAdapter;
import br.com.digitalhouse.rxjava.model.Usuario;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private UsuarioRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new UsuarioRecyclerViewAdapter(new ArrayList<Usuario>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Você clicou no botão", Snackbar.LENGTH_SHORT).show();
        });

        // Streams
        // -- Java 8
        // -- Labdas e Streams

        // Theads
        // -- O que é
        // -- Thread de trabalho
        // -- Main Thread
        // -- runOnUiThread

        // RxJava
        // -- Observable
        // -- Operator (map, filter, flatmap)
        // -- Observer (subscribe)
        // ---- Cold/Lazy Observer
        // ---- Observable.just
        // ---- Observable.range
        // ---- Observable.fromIterable
        // ---- Observable.create


        Observable.range(0, 100)
                .map(numero -> numero * 2)
                .filter(numero -> numero == 9)
                .subscribe(integer -> {
                    System.out.println(integer);
                }, throwable -> {
                    System.out.println("ERROR: " + throwable.getMessage());
                }, () -> {
                });

        Observable.fromIterable(Arrays.asList("Lucas", "Gabriel"))
                .map(nome -> nome.equals("Lucas"))
                .subscribe(n -> {
                    System.out.println(n);
                }, throwable -> {
                    System.out.println("ERROR: " + throwable.getMessage());
                }, () -> {
                });

        Observable.just("Lucas")
                .subscribe(integer -> {
                    System.out.println(integer);
                }, throwable -> {
                    System.out.println("ERROR: " + throwable.getMessage());
                }, () -> {
                });


        Observable<String> stringObservable = Observable.create(emitter -> {
            emitter.onNext("Lucas");
            emitter.onNext("Gabriel");
            emitter.onComplete();
        });

        stringObservable
                .filter(nome -> nome.equals("Santos"))
                .subscribe(s -> {
                    //sucesso
                }, throwable -> {
                    //erro
                }, () -> {
                    //completou
                });

        getUsuario()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(usuarios -> {
                    //Sucesso
                    adapter.update(usuarios);
                },throwable -> {
                   //Erro
                    Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
                });
    }

    private Observable<List<Usuario>> getUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Lucas", 22));
        usuarios.add(new Usuario("Gabriel", 22));
        usuarios.add(new Usuario("Santos", 22));
        usuarios.add(new Usuario("Bruna", 23));

        return Observable.just(usuarios);
    }
}