package br.com.digitalhouse.firebaseapp.lucasg.favorites.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.lucasg.adapters.FavoritesViewAdapter;
import br.com.digitalhouse.firebaseapp.lucasg.interfaces.FavoriteItemClick;
import br.com.digitalhouse.firebaseapp.lucasg.model.Result;
import br.com.digitalhouse.firebaseapp.lucasg.util.AppUtil;

public class FavoritesActivity extends AppCompatActivity implements FavoriteItemClick {
    private RecyclerView recyclerView;
    private FavoritesViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new FavoritesViewAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);

        // TODO: Listar itens salvos no firebase database


    }

    private void carregarFavorites(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(AppUtil.getIdUsuario(getApplication()) + "/favorites");
        reference.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Result> results = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Result result = child.getValue(Result.class);
                    results.add(result);
                }

                adapter.update(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void addFavoriteClickListener(Result result) {

    }

    @Override
    public void removeFavoriteClickListener(Result result) {

        // TODO: remover item do firebase database
    }
}
