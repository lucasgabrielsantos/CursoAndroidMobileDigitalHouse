package br.com.digitalhouse.androidroom.Interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.androidroom.models.Produto;
import io.reactivex.Observable;


@Dao
public interface ProdutoDao {

    @Insert
    void insereProduto(Produto produto);

    @Delete
    void deleteProduto(Produto produto);

    @Update
    void updateProduto(Produto produto);

    @Query("SELECT * FROM produtos")
    Observable<List<Produto>> getAllProdutos();

    @Query("SELECT * FROM produtos WHERE id = :id")
    Produto getById(long id);

    @Query("SELECT * FROM produtos WHERE nome = :nomeProduto")
    Produto getByNome(String nomeProduto);


}
