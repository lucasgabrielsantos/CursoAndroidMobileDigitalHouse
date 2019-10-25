package br.com.digitalhouse.appmytasks.model.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;
import io.reactivex.Observable;

@Dao
public interface TarefaDao {

    @Insert
    void insereTarefa(Tarefa tarefa);

    // O app precisará de:
    @Delete
    void deleteTarefa(Tarefa tarefa);

    // - Inserção de dados
    @Update
    void updateTarefa(Tarefa tarefa);


    @Query("SELECT * FROM tarefas")
    Observable<List<Tarefa>> getAllTarefas();

    @Query("SELECT * FROM tarefas WHERE id = :id")
    Tarefa getById(long id);

    @Query("SELECT * FROM tarefas ORDER BY id DESC LIMIT 5")
    Observable<List<Tarefa>> getAllTarefasLimit();


    //- Consulta de todos os dados
    // - Consulta contendo um limite de 5 dados em ordem decrescente

}
