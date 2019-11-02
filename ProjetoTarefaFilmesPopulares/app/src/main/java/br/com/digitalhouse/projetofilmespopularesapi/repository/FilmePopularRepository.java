package br.com.digitalhouse.projetofilmespopularesapi.repository;

import br.com.digitalhouse.projetofilmespopularesapi.model.FilmePopular;
import io.reactivex.Observable;

import static br.com.digitalhouse.projetofilmespopularesapi.data.remote.RetrofitService.getApiService;

public class FilmePopularRepository {

    public Observable<FilmePopular> getFilmesPop(String apiKey){
        return getApiService().getAllFilmesPop(apiKey);
    }
}
