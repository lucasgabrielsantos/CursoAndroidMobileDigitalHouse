package br.com.digitalhouse.tarefajsonlocal.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.digitalhouse.tarefajsonlocal.model.NoticiaResposta;
import io.reactivex.Observable;

public class NoticiaRepository {


    public Observable<NoticiaResposta> obterListaNoticias(Context context) {

        try {
            AssetManager manager = context.getAssets();
            InputStream inputStream = manager.open("noticias.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            Gson gson = new Gson();

            NoticiaResposta resposta = gson.fromJson(reader, NoticiaResposta.class);

            return Observable.just(resposta);


        } catch (Exception ex) {
            ex.printStackTrace();


            return Observable.error(ex.getCause());

        }
    }
}