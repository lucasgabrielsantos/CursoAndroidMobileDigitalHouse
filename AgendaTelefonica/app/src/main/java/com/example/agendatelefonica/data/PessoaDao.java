package com.example.agendatelefonica.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agendatelefonica.models.Pessoa;

import java.util.List;

import io.reactivex.Observable;

import static android.icu.text.MessagePattern.ArgType.SELECT;

@Dao
public interface PessoaDao {
    @Insert
    void inserePessoa(Pessoa pessoa);

    @Query("SELECT * FROM pessoas")
    Observable<List<Pessoa>> getAllPessoas();

}
