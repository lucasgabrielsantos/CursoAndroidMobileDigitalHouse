package br.com.digitalhouse.androidroom.data;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import br.com.digitalhouse.androidroom.Interfaces.ProdutoDao;
import br.com.digitalhouse.androidroom.models.Produto;

@androidx.room.Database(entities = {Produto.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract ProdutoDao produtoDao();


    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "produtos_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}