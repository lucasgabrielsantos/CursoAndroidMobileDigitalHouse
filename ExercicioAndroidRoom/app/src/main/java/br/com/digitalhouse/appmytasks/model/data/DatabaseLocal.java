package br.com.digitalhouse.appmytasks.model.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.digitalhouse.appmytasks.model.data.TarefaDao;
import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;

@androidx.room.Database(entities = {Tarefa.class}, version = 1, exportSchema = false)

public abstract class DatabaseLocal extends RoomDatabase {

    private static volatile DatabaseLocal INSTANCE;

    public abstract TarefaDao tarefaDao();


    public static DatabaseLocal getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseLocal.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, DatabaseLocal.class, "tarefas_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}