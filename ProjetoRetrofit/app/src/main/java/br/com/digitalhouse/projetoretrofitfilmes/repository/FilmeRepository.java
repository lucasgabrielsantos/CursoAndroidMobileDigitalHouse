package br.com.digitalhouse.projetoretrofitfilmes.repository;

import br.com.digitalhouse.projetoretrofitfilmes.model.Results;
import io.reactivex.Observable;

import static br.com.digitalhouse.projetoretrofitfilmes.data.remote.RetrofitService.getApiService;

public class FilmeRepository {

    public Observable<Results> getFilmes(String apiKey){
        return getApiService().getAllFilmes(apiKey);
    }
}
